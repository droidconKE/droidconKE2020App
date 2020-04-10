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
        sViewsWithIds.put(R.id.sessionsLabel, 12);
        sViewsWithIds.put(R.id.llCards, 13);
        sViewsWithIds.put(R.id.tvTwitterHandleLabel, 14);
        sViewsWithIds.put(R.id.rlSpeakerHandle, 15);
        sViewsWithIds.put(R.id.copyIcon, 16);
        sViewsWithIds.put(R.id.textView, 17);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSpeakerDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentSpeakerDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (cn.gavinliu.android.lib.shapedimageview.ShapedImageView) bindings[1]
            , (android.view.View) bindings[9]
            , (android.widget.ScrollView) bindings[0]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.LinearLayout) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[15]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[14]
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
                mDirtyFlags = 0x2L;
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
        if (BR.speaker == variableId) {
            setSpeaker((com.android254.droidconKE2020.speakers.models.Speaker) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSpeaker(@Nullable com.android254.droidconKE2020.speakers.models.Speaker Speaker) {
        this.mSpeaker = Speaker;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
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
        java.lang.String javaLangStringSpeakerSocialMediaTwitter = null;
        com.android254.droidconKE2020.speakers.models.Speaker speaker = mSpeaker;
        com.android254.droidconKE2020.speakers.models.SocialMedia speakerSocialMedia = null;
        java.lang.String speakerBio = null;
        java.lang.String speakerName = null;
        java.lang.String speakerImageUrl = null;
        java.lang.String speakerSocialMediaTwitter = null;
        java.lang.String speakerCompany = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (speaker != null) {
                    // read speaker.work
                    speakerWork = speaker.getWork();
                    // read speaker.socialMedia
                    speakerSocialMedia = speaker.getSocialMedia();
                    // read speaker.bio
                    speakerBio = speaker.getBio();
                    // read speaker.name
                    speakerName = speaker.getName();
                    // read speaker.imageUrl
                    speakerImageUrl = speaker.getImageUrl();
                    // read speaker.company
                    speakerCompany = speaker.getCompany();
                }


                if (speakerSocialMedia != null) {
                    // read speaker.socialMedia.twitter
                    speakerSocialMediaTwitter = speakerSocialMedia.getTwitter();
                }


                // read ("@") + (speaker.socialMedia.twitter)
                javaLangStringSpeakerSocialMediaTwitter = ("@") + (speakerSocialMediaTwitter);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.android254.droidconKE2020.core.utils.BindingAdapterKt.loadImage(this.circleImageView, speakerImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerBio, speakerBio);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerCompany, speakerCompany);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerHandle, javaLangStringSpeakerSocialMediaTwitter);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerName, speakerName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSpeakerRole, speakerWork);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTopTwitterHandle, javaLangStringSpeakerSocialMediaTwitter);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): speaker
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}