package com.ifts4.introduccionandroid.ui.list

import com.ifts4.introduccionandroid.data.model.User

interface OnUserClick {
    fun onClick(user: User)
}