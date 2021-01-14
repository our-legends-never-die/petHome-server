package com.github.pethome.common.util

import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

/**
 * 地图坐标工具类
 *
 * @author Chimm Huang
 */
object MapCoordinateUtil {

    class MapCoordinate(var lngMin: Double?, var lngMax: Double?, var latMin: Double?, var latMax: Double?)

    private var R = 6371.137 //R为地球半径，可取平均值 6371.137km

    /**
     * 计算附近
     *
     * @param longitude 经度
     * @param latitude 纬度
     * @param distance 距离（单位km）
     * @return 指定范围的经纬度
     */
    fun findNeighPosition(longitude: Double, latitude: Double, distance: Int): MapCoordinate {

        //先计算查询点的经纬度范围
        var dlng = 2 * asin(sin(distance / (2 * R)) / cos(latitude * Math.PI / 180)) //⊿λ东西两侧的的范围边界
        dlng = dlng * 180 / Math.PI //角度转为弧度
        var dlat: Double = distance / R //⊿φ南北两侧的范围边界
        dlat = dlat * 180 / Math.PI //角度转为弧度

        val lngMin = longitude - dlng
        val lngMax = longitude + dlng
        val latMin = latitude - dlat
        val latMax = latitude + dlat

        return MapCoordinate(lngMin, lngMax, latMin, latMax)
    }

}