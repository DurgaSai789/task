package com.example.hyderabadtask.ui.schedulepic.model


import com.example.hyderabadtask.R

class HowDoesRepository {

    suspend fun getHowDoesItems(): List<HowDoes> {
        return listOf(
            HowDoes(image = R.drawable.one, imageName = "Schedule Pickup"),
            HowDoes(image = R.drawable.two, imageName = "We Collect"),
            HowDoes(image = R.drawable.three, imageName = "We Service"),
            HowDoes(image = R.drawable.four, imageName = "We Deliver")
        )
    }
}
