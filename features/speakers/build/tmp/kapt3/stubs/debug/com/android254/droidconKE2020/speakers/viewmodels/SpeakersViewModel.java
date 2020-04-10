package com.android254.droidconKE2020.speakers.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/android254/droidconKE2020/speakers/viewmodels/SpeakersViewModel;", "Landroidx/lifecycle/ViewModel;", "speakerRepository", "Lcom/android254/droidconKE2020/speakers/viewmodels/FakeSpeakerRepository;", "(Lcom/android254/droidconKE2020/speakers/viewmodels/FakeSpeakerRepository;)V", "_searchPhrase", "Landroidx/lifecycle/MutableLiveData;", "", "searchPhrase", "getSearchPhrase", "()Landroidx/lifecycle/MutableLiveData;", "speakerList", "", "Lcom/android254/droidconKE2020/speakers/models/Speaker;", "getSpeakerList", "adjustStars", "", "speakerId", "", "retrieveSpeakerList", "setSearchPhrase", "value", "speakers_debug"})
public final class SpeakersViewModel extends androidx.lifecycle.ViewModel {
    
    /**
     * Search stuff
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _searchPhrase = null;
    private final com.android254.droidconKE2020.speakers.viewmodels.FakeSpeakerRepository speakerRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchPhrase() {
        return null;
    }
    
    public final void setSearchPhrase(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.android254.droidconKE2020.speakers.models.Speaker>> getSpeakerList() {
        return null;
    }
    
    public final void retrieveSpeakerList(@org.jetbrains.annotations.Nullable()
    java.lang.String searchPhrase) {
    }
    
    /**
     * Star stuff
     */
    public final void adjustStars(int speakerId) {
    }
    
    public SpeakersViewModel(@org.jetbrains.annotations.NotNull()
    com.android254.droidconKE2020.speakers.viewmodels.FakeSpeakerRepository speakerRepository) {
        super();
    }
}