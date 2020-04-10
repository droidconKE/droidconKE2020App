package com.android254.droidconKE2020.speakers.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/android254/droidconKE2020/speakers/viewmodels/FakeSpeakerRepository;", "", "()V", "db", "", "Lcom/android254/droidconKE2020/speakers/models/Speaker;", "keynoteSpeaker", "Landroidx/lifecycle/MutableLiveData;", "getKeynoteSpeaker", "()Landroidx/lifecycle/MutableLiveData;", "sessionSpeakers", "", "getSessionSpeakers", "refreshSpeakers", "", "retrieveSpeaker", "speakerId", "", "searchSpeakers", "searchPhrase", "", "speakers_debug"})
public final class FakeSpeakerRepository {
    private final java.util.List<com.android254.droidconKE2020.speakers.models.Speaker> db = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.android254.droidconKE2020.speakers.models.Speaker> keynoteSpeaker = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.android254.droidconKE2020.speakers.models.Speaker>> sessionSpeakers = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.android254.droidconKE2020.speakers.models.Speaker> getKeynoteSpeaker() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.android254.droidconKE2020.speakers.models.Speaker>> getSessionSpeakers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.android254.droidconKE2020.speakers.models.Speaker retrieveSpeaker(int speakerId) {
        return null;
    }
    
    public final void searchSpeakers(@org.jetbrains.annotations.NotNull()
    java.lang.String searchPhrase) {
    }
    
    public final void refreshSpeakers() {
    }
    
    public FakeSpeakerRepository() {
        super();
    }
}