package com.android254.droidconKE2020.speaker.databinding;
import com.android254.droidconKE2020.speaker.R;
import com.android254.droidconKE2020.speaker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSpeakerDetailsBindingImpl extends FragmentSpeakerDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imgSpeakerToolbar, 8);
        sViewsWithIds.put(R.id.circleImageViewBg, 9);
        sViewsWithIds.put(R.id.imgTwitter, 10);
        sViewsWithIds.put(R.id.tvSpeakerBioLabel, 11);
        sViewsWithIds.put(R.id.tvTwitterHandleLabel, 12);
        sViewsWithIds.put(R.id.rlSpeakerHandle, 13);
        sViewsWithIds.put(R.id.copyIcon, 14);
        sViewsWithIds.put(R.id.textView, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSpeakerDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragmentSpeakerDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (cn.gavinliu.android.lib.shapedimageview.ShapedImageView) bindings[1]
            , (android.view.View) bindings[9]
            , (android.widget.ScrollView) bindings[0]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[12]
            );
        this.circleImageView.setTag(null);
        this.constraintLayout.setTag(null);
        this.tvSpeakerBio.setTag(null);
        this.tvSpeakerCompany.setTag(null);
        this.tvSpeakerHandle.setTag(null);
        this.tvSpeakerName.setTag(null);
        this.tvSpeakerRole.setTag(null);
        this.tvTopTwitterHandle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.speakerDetailsModel == variableId) {
            setSpeakerDetailsModel((com.android254.droidconKE2020.speaker.models.SpeakerDetailsModel) variable);
        }
        else if (BR.speakerImg == variableId) {
            setSpeakerImg((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSpeakerDetailsModel(@Nullable com.android254.droidconKE2020.speaker.models.SpeakerDetailsModel SpeakerDetailsModel) {
        this.mSpeakerDetailsModel = SpeakerDetailsModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.speakerDetailsModel);
        super.requestRebind();
    }
    public void setSpeakerImg(@Nullable java.lang.String SpeakerImg) {
        this.mSpeakerImg = SpeakerImg;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.speakerImg);
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
        java.lang.String speakerDetailsModelTwitterHandle = null;
        com.android254.droidconKE2020.speaker.models.SpeakerDetailsModel speakerDetailsModel = mSpeakerDetailsModel;
        java.lang.String speakerDetailsModelSpeakerRole = null;
        java.lang.String speakerImg = mSpeakerImg;
        java.lang.String speakerDetailsModelSpeakerName = null;
        java.lang.String speakerDetailsModelSpeakerCompany = null;
        java.lang.String speakerDetailsModelSpeakerBio = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (speakerDetailsModel != null) {
                    // read speakerDetailsModel.twitterHandle
                    speakerDetailsModelTwitterHandle = speakerDetailsModel.getTwitterHandle();
                    // read speakerDetailsModel.speakerRole
                    speakerDetailsModelSpeakerRole = speakerDetailsModel.getSpeakerRole();
                    // read speakerDetailsModel.speakerName
                    speakerDetailsModelSpeakerName = speakerDetailsModel.getSpeakerName();
                    // read speakerDetailsModel.speakerCompany
                    speakerDetailsModelSpeakerCompany = speakerDetailsModel.getSpeakerCompany();
                    // read speakerDetailsModel.speakerBio
                    speakerDetailsModelSpeakerBio = speakerDetailsModel.getSpeakerBio();
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.android254.droidconKE2020.core.utils.BindingAdapterKt.loadImage(this.circleImageView, speakerImg);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerBio, speakerDetailsModelSpeakerBio);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerCompany, speakerDetailsModelSpeakerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerHandle, speakerDetailsModelTwitterHandle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerName, speakerDetailsModelSpeakerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerRole, speakerDetailsModelSpeakerRole);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTopTwitterHandle, speakerDetailsModelTwitterHandle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): speakerDetailsModel
        flag 1 (0x2L): speakerImg
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}