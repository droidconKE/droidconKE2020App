package com.android254.droidconKE2020.speaker.views.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.android254.droidconKE2020.speaker.models.SpeakerDetailsModel

class SpeakerViewModel : ViewModel() {
    val speakerDetails = MediatorLiveData<SpeakerDetailsModel>()


    fun fetchSpeakerDetails(){
        val speakerDetailsModel = SpeakerDetailsModel("John Doe","@johndoe","Design Labs","Chief Executive Office","Been in the tech industry for over 20 years. Am passionate about developer communities, motivating people and building successful organizations. Proven track record in product development, business development,\n" +
                "    and nurturing mission critical strategic partner relationships. Have lived and worked in Germany for 10 years. Fluent in German and English","https://firebasestorage.googleapis.com/v0/b/droidconke-70d60.appspot.com/o/speakers2019%2Fjabez-mu.png?alt=media&token=ece3cbbd-b896-4748-9d9a-39e58391db92")
        speakerDetails.value = speakerDetailsModel
    }


}