package com.android254.droidconKE2020.speaker.databinding;
import com.android254.droidconKE2020.speaker.R;
import com.android254.droidconKE2020.speaker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSpeakerBindingImpl extends ItemSpeakerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cgSkills, 8);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSpeakerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ItemSpeakerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[5]
            , (com.google.android.material.chip.ChipGroup) bindings[8]
            , (cn.gavinliu.android.lib.shapedimageview.ShapedImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[4]
            );
        this.btnStar.setTag(null);
        this.imgContainer.setTag(null);
        this.llStars.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvCompany.setTag(null);
        this.tvName.setTag(null);
        this.tvRole.setTag(null);
        this.tvStars.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.openSpeakerDetails == variableId) {
            setOpenSpeakerDetails((android.view.View.OnClickListener) variable);
        }
        else if (BR.adjustStars == variableId) {
            setAdjustStars((android.view.View.OnClickListener) variable);
        }
        else if (BR.isLoggedIn == variableId) {
            setIsLoggedIn((java.lang.Boolean) variable);
        }
        else if (BR.speaker == variableId) {
            setSpeaker((com.android254.droidconKE2020.speakers.models.Speaker) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOpenSpeakerDetails(@Nullable android.view.View.OnClickListener OpenSpeakerDetails) {
        this.mOpenSpeakerDetails = OpenSpeakerDetails;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.openSpeakerDetails);
        super.requestRebind();
    }
    public void setAdjustStars(@Nullable android.view.View.OnClickListener AdjustStars) {
        this.mAdjustStars = AdjustStars;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.adjustStars);
        super.requestRebind();
    }
    public void setIsLoggedIn(@Nullable java.lang.Boolean IsLoggedIn) {
        this.mIsLoggedIn = IsLoggedIn;
    }
    public void setSpeaker(@Nullable com.android254.droidconKE2020.speakers.models.Speaker Speaker) {
        this.mSpeaker = Speaker;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.speaker);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String speakerWork = null;
        android.view.View.OnClickListener openSpeakerDetails = mOpenSpeakerDetails;
        java.lang.String integerToStringSpeakerStarsSize = null;
        java.lang.String speakerName = null;
        android.view.View.OnClickListener adjustStars = mAdjustStars;
        java.lang.String speakerImageUrl = null;
        java.util.List<java.lang.Integer> speakerStars = null;
        java.lang.String speakerCompany = null;
        com.android254.droidconKE2020.speakers.models.Speaker speaker = mSpeaker;
        int speakerStarsSize = 0;

        if ((dirtyFlags & 0x11L) != 0) {
        }
        if ((dirtyFlags & 0x12L) != 0) {
        }
        if ((dirtyFlags & 0x18L) != 0) {



                if (speaker != null) {
                    // read speaker.work
                    speakerWork = speaker.getWork();
                    // read speaker.name
                    speakerName = speaker.getName();
                    // read speaker.imageUrl
                    speakerImageUrl = speaker.getImageUrl();
                    // read speaker.stars
                    speakerStars = speaker.getStars();
                    // read speaker.company
                    speakerCompany = speaker.getCompany();
                }


                if (speakerStars != null) {
                    // read speaker.stars.size()
                    speakerStarsSize = speakerStars.size();
                }


                // read Integer.toString(speaker.stars.size())
                integerToStringSpeakerStarsSize = java.lang.Integer.toString(speakerStarsSize);
        }
        // batch finished
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            this.btnStar.setOnClickListener(adjustStars);
            this.llStars.setOnClickListener(adjustStars);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.android254.droidconKE2020.core.utils.BindingAdapterKt.loadImage(this.imgContainer, speakerImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCompany, speakerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, speakerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvRole, speakerWork);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvStars, integerToStringSpeakerStarsSize);
        }
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(openSpeakerDetails);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): openSpeakerDetails
        flag 1 (0x2L): adjustStars
        flag 2 (0x3L): isLoggedIn
        flag 3 (0x4L): speaker
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}