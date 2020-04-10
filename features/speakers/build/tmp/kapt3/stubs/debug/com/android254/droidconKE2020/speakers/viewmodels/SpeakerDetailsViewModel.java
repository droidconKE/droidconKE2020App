package com.android254.droidconKE2020.speakers.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/android254/droidconKE2020/speakers/viewmodels/SpeakerDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "speakerRepository", "Lcom/android254/droidconKE2020/speakers/viewmodels/FakeSpeakerRepository;", "(Lcom/android254/droidconKE2020/speakers/viewmodels/FakeSpeakerRepository;)V", "_speaker", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android254/droidconKE2020/speakers/models/Speaker;", "speakerDetails", "getSpeakerDetails", "()Landroidx/lifecycle/MutableLiveData;", "fetchSpeakerDetails", "", "speakerId", "", "speakers_debug"})
public final class SpeakerDetailsViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.android254.droidconKE2020.speakers.models.Speaker> _speaker = null;
    private final com.android254.droidconKE2020.speakers.viewmodels.FakeSpeakerRepository speakerRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.android254.droidconKE2020.speakers.models.Speaker> getSpeakerDetails() {
        return null;
    }
    
    public final void fetchSpeakerDetails(int speakerId) {
    }
    
    public SpeakerDetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.android254.droidconKE2020.speakers.viewmodels.FakeSpeakerRepository speakerRepository) {
        super();
    }
}