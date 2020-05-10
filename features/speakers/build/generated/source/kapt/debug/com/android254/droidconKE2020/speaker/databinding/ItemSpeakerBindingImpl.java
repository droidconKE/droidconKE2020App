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
        sViewsWithIds.put(R.id.cgSkills, 5);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSpeakerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemSpeakerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.chip.ChipGroup) bindings[5]
            , (cn.gavinliu.android.lib.shapedimageview.ShapedImageView) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.imgContainer.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvCompany.setTag(null);
        this.tvName.setTag(null);
        this.tvRole.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
    public void setIsLoggedIn(@Nullable java.lang.Boolean IsLoggedIn) {
        this.mIsLoggedIn = IsLoggedIn;
    }
    public void setSpeaker(@Nullable com.android254.droidconKE2020.speakers.models.Speaker Speaker) {
        this.mSpeaker = Speaker;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
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
        java.lang.String speakerName = null;
        java.lang.String speakerImageUrl = null;
        java.lang.String speakerCompany = null;
        com.android254.droidconKE2020.speakers.models.Speaker speaker = mSpeaker;

        if ((dirtyFlags & 0x9L) != 0) {
        }
        if ((dirtyFlags & 0xcL) != 0) {



                if (speaker != null) {
                    // read speaker.work
                    speakerWork = speaker.getWork();
                    // read speaker.name
                    speakerName = speaker.getName();
                    // read speaker.imageUrl
                    speakerImageUrl = speaker.getImageUrl();
                    // read speaker.company
                    speakerCompany = speaker.getCompany();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.android254.droidconKE2020.core.utils.BindingAdapterKt.loadImage(this.imgContainer, speakerImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvCompany, speakerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvName, speakerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvRole, speakerWork);
        }
        if ((dirtyFlags & 0x9L) != 0) {
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
        flag 1 (0x2L): isLoggedIn
        flag 2 (0x3L): speaker
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}