package com.android254.droidconKE2020.speaker.databinding;
import com.android254.droidconKE2020.speaker.R;
import com.android254.droidconKE2020.speaker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSpeakersBindingImpl extends FragmentSpeakersBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.home_appBarLayout, 5);
        sViewsWithIds.put(R.id.imgSearch, 6);
        sViewsWithIds.put(R.id.rvSpeakers, 7);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener tvSearchandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of speakersViewModel.searchPhrase.getValue()
            //         is speakersViewModel.searchPhrase.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(tvSearch);
            // localize variables for thread safety
            // speakersViewModel.searchPhrase.getValue()
            java.lang.String speakersViewModelSearchPhraseGetValue = null;
            // speakersViewModel != null
            boolean speakersViewModelJavaLangObjectNull = false;
            // speakersViewModel
            com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel speakersViewModel = mSpeakersViewModel;
            // speakersViewModel.searchPhrase != null
            boolean speakersViewModelSearchPhraseJavaLangObjectNull = false;
            // speakersViewModel.searchPhrase
            androidx.lifecycle.MutableLiveData<java.lang.String> speakersViewModelSearchPhrase = null;



            speakersViewModelJavaLangObjectNull = (speakersViewModel) != (null);
            if (speakersViewModelJavaLangObjectNull) {


                speakersViewModelSearchPhrase = speakersViewModel.getSearchPhrase();

                speakersViewModelSearchPhraseJavaLangObjectNull = (speakersViewModelSearchPhrase) != (null);
                if (speakersViewModelSearchPhraseJavaLangObjectNull) {




                    speakersViewModelSearchPhrase.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentSpeakersBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentSpeakersBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.appbar.AppBarLayout) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.EditText) bindings[3]
            );
        this.backBtn.setTag(null);
        this.backProfile.setTag(null);
        this.imgLogo.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvSearch.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
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
        if (BR.clearSearch == variableId) {
            setClearSearch((android.view.View.OnClickListener) variable);
        }
        else if (BR.openProfile == variableId) {
            setOpenProfile((android.view.View.OnClickListener) variable);
        }
        else if (BR.goBack == variableId) {
            setGoBack((android.view.View.OnClickListener) variable);
        }
        else if (BR.initiateEasterEgg == variableId) {
            setInitiateEasterEgg((android.view.View.OnClickListener) variable);
        }
        else if (BR.speakersViewModel == variableId) {
            setSpeakersViewModel((com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClearSearch(@Nullable android.view.View.OnClickListener ClearSearch) {
        this.mClearSearch = ClearSearch;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.clearSearch);
        super.requestRebind();
    }
    public void setOpenProfile(@Nullable android.view.View.OnClickListener OpenProfile) {
        this.mOpenProfile = OpenProfile;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.openProfile);
        super.requestRebind();
    }
    public void setGoBack(@Nullable android.view.View.OnClickListener GoBack) {
        this.mGoBack = GoBack;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.goBack);
        super.requestRebind();
    }
    public void setInitiateEasterEgg(@Nullable android.view.View.OnClickListener InitiateEasterEgg) {
        this.mInitiateEasterEgg = InitiateEasterEgg;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.initiateEasterEgg);
        super.requestRebind();
    }
    public void setSpeakersViewModel(@Nullable com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel SpeakersViewModel) {
        this.mSpeakersViewModel = SpeakersViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.speakersViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeSpeakersViewModelSearchPhrase((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeSpeakersViewModelSearchPhrase(androidx.lifecycle.MutableLiveData<java.lang.String> SpeakersViewModelSearchPhrase, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        android.view.View.OnClickListener clearSearch = mClearSearch;
        android.view.View.OnClickListener speakersViewModelSearchPhraseEmptyInitiateEasterEggClearSearch = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> speakersViewModelSearchPhrase = null;
        boolean speakersViewModelSearchPhraseEmpty = false;
        android.view.View.OnClickListener openProfile = mOpenProfile;
        android.view.View.OnClickListener goBack = mGoBack;
        java.lang.String speakersViewModelSearchPhraseGetValue = null;
        android.view.View.OnClickListener initiateEasterEgg = mInitiateEasterEgg;
        com.android254.droidconKE2020.speakers.viewmodels.SpeakersViewModel speakersViewModel = mSpeakersViewModel;

        if ((dirtyFlags & 0x44L) != 0) {
        }
        if ((dirtyFlags & 0x48L) != 0) {
        }
        if ((dirtyFlags & 0x73L) != 0) {



                if (speakersViewModel != null) {
                    // read speakersViewModel.searchPhrase
                    speakersViewModelSearchPhrase = speakersViewModel.getSearchPhrase();
                }
                updateLiveDataRegistration(0, speakersViewModelSearchPhrase);


                if (speakersViewModelSearchPhrase != null) {
                    // read speakersViewModel.searchPhrase.getValue()
                    speakersViewModelSearchPhraseGetValue = speakersViewModelSearchPhrase.getValue();
                }


                if (speakersViewModelSearchPhraseGetValue != null) {
                    // read speakersViewModel.searchPhrase.getValue().empty
                    speakersViewModelSearchPhraseEmpty = speakersViewModelSearchPhraseGetValue.isEmpty();
                }
            if((dirtyFlags & 0x73L) != 0) {
                if(speakersViewModelSearchPhraseEmpty) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x80L) != 0) {
        }
        if ((dirtyFlags & 0x100L) != 0) {
        }

        if ((dirtyFlags & 0x73L) != 0) {

                // read speakersViewModel.searchPhrase.getValue().empty ? initiateEasterEgg : clearSearch
                speakersViewModelSearchPhraseEmptyInitiateEasterEggClearSearch = ((speakersViewModelSearchPhraseEmpty) ? (initiateEasterEgg) : (clearSearch));
        }
        // batch finished
        if ((dirtyFlags & 0x48L) != 0) {
            // api target 1

            this.backBtn.setOnClickListener(goBack);
        }
        if ((dirtyFlags & 0x44L) != 0) {
            // api target 1

            this.backProfile.setOnClickListener(openProfile);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            com.android254.droidconKE2020.speakers.utils.BindingAdapterKt.droidconLogoImageResource(this.imgLogo, speakersViewModelSearchPhraseEmpty);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSearch, speakersViewModelSearchPhraseGetValue);
        }
        if ((dirtyFlags & 0x73L) != 0) {
            // api target 1

            this.imgLogo.setOnClickListener(speakersViewModelSearchPhraseEmptyInitiateEasterEggClearSearch);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvSearch, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvSearchandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): speakersViewModel.searchPhrase
        flag 1 (0x2L): clearSearch
        flag 2 (0x3L): openProfile
        flag 3 (0x4L): goBack
        flag 4 (0x5L): initiateEasterEgg
        flag 5 (0x6L): speakersViewModel
        flag 6 (0x7L): null
        flag 7 (0x8L): speakersViewModel.searchPhrase.getValue().empty ? initiateEasterEgg : clearSearch
        flag 8 (0x9L): speakersViewModel.searchPhrase.getValue().empty ? initiateEasterEgg : clearSearch
    flag mapping end*/
    //end
}