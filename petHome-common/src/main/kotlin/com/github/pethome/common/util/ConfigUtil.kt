package com.github.pethome.common.util

import org.yaml.snakeyaml.Yaml
import java.util.HashMap


/**
 * @author Chimm Huang
 */
object ConfigUtil {

    private var ymlMap: Map<String, Any> = HashMap()

    init {
        val resourceAsStream = ConfigUtil::class.java.classLoader.getResourceAsStream("application.yml")
        ymlMap = Yaml().loadAs(resourceAsStream, HashMap::class.java) as Map<String, Any>
        resourceAsStream.close()
    }

    /**
     * 获取配置信息
     *
     * @param propName 配置 key
     * @return 配置 value
     */
    fun getPropByName(propName: String): String? {
        return getPropByName(propName, null)
    }

    /**
     * 获取配置信息
     *
     * @param propName 配置 key
     * @param defaultValue 若没有获取到值，或值为 null，则赋上默认值
     * @return 配置 value
     */
    fun getPropByName(propName: String, defaultValue: String?): String? {

        var separator: String = "."
        var separatorKeys: List<String>

        if (propName.contains(separator)) {
            separatorKeys = propName.split(separator)
        } else {
            return ymlMap.get(propName).toString()
        }

        var finalValue: String? = null
        var valueMap: Any? = null

        for (i in separatorKeys.indices) {
            if (i == 0) {
                valueMap = ymlMap.get(separatorKeys.get(i))
                continue
            }

            if (valueMap == null) {
                break
            }

            valueMap = valueMap as HashMap<String, Any>
            if (i == separatorKeys.size - 1) {
                finalValue = valueMap.get(separatorKeys.get(i)).toString()
            }

            valueMap = valueMap.get(separatorKeys.get(i))
        }

        return finalValue ?: defaultValue
    }

}