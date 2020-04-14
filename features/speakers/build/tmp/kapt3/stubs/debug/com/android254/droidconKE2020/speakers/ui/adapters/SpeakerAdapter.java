package com.android254.droidconKE2020.speakers.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/android254/droidconKE2020/speakers/ui/adapters/SpeakerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/android254/droidconKE2020/repository/models/Speaker;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSpeakerClicked", "Lkotlin/Function1;", "", "onStarClicked", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnSpeakerClicked", "()Lkotlin/jvm/functions/Function1;", "getOnStarClicked", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SpeakerDiffCallback", "SpeakerViewHolder", "speakers_debug"})
public final class SpeakerAdapter extends androidx.recyclerview.widget.ListAdapter<com.android254.droidconKE2020.repository.models.Speaker, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.android254.droidconKE2020.repository.models.Speaker, kotlin.Unit> onSpeakerClicked = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onStarClicked = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.android254.droidconKE2020.repository.models.Speaker, kotlin.Unit> getOnSpeakerClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> getOnStarClicked() {
        return null;
    }
    
    public SpeakerAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.android254.droidconKE2020.repository.models.Speaker, kotlin.Unit> onSpeakerClicked, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onStarClicked) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/android254/droidconKE2020/speakers/ui/adapters/SpeakerAdapter$SpeakerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/android254/droidconKE2020/speaker/databinding/ItemSpeakerBinding;", "(Lcom/android254/droidconKE2020/speakers/ui/adapters/SpeakerAdapter;Lcom/android254/droidconKE2020/speaker/databinding/ItemSpeakerBinding;)V", "bind", "", "item", "Lcom/android254/droidconKE2020/repository/models/Speaker;", "speakers_debug"})
    public final class SpeakerViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBinding binding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.repository.models.Speaker item) {
        }
        
        public SpeakerViewHolder(@org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBinding binding) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/android254/droidconKE2020/speakers/ui/adapters/SpeakerAdapter$SpeakerDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/android254/droidconKE2020/repository/models/Speaker;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "speakers_debug"})
    public static final class SpeakerDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.android254.droidconKE2020.repository.models.Speaker> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.repository.models.Speaker oldItem, @org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.repository.models.Speaker newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.repository.models.Speaker oldItem, @org.jetbrains.annotations.NotNull()
        com.android254.droidconKE2020.repository.models.Speaker newItem) {
            return false;
        }
        
        public SpeakerDiffCallback() {
            super();
        }
    }
}