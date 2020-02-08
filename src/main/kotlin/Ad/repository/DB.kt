package Ad.repository

import Ad.model.AdEvent

interface DB {
    val array: Array<AdEvent>
}