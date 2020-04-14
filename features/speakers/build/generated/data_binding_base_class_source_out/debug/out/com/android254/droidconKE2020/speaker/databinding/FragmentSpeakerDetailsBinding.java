// Generated by data binding compiler. Do not edit!
package com.android254.droidconKE2020.speaker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView;
import com.android254.droidconKE2020.repository.models.Speaker;
import com.android254.droidconKE2020.speaker.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSpeakerDetailsBinding extends ViewDataBinding {
  @NonNull
  public final ShapedImageView circleImageView;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   */
  @Nullable
  public final View circleImageViewBg;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final ConstraintLayout clBioData;

  @NonNull
  public final ScrollView constraintLayout;

  @NonNull
  public final ImageView copyIcon;

  @NonNull
  public final ImageView imgSpeakerToolbar;

  @NonNull
  public final ImageView imgTwitter;

  @NonNull
  public final LinearLayout llCards;

  @NonNull
  public final ConstraintLayout rlSpeakerHandle;

  @NonNull
  public final TextView sessionsLabel;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView tvSpeakerBio;

  @NonNull
  public final TextView tvSpeakerBioLabel;

  @NonNull
  public final TextView tvSpeakerCompany;

  @NonNull
  public final TextView tvSpeakerHandle;

  @NonNull
  public final TextView tvSpeakerName;

  @NonNull
  public final TextView tvSpeakerRole;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   */
  @Nullable
  public final TextView tvTopTwitterHandle;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   */
  @Nullable
  public final TextView tvTwitterHandleLabel;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout-land/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   */
  @Nullable
  public final Guideline verticalGuideline;

  @Bindable
  protected Speaker mSpeaker;

  protected FragmentSpeakerDetailsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ShapedImageView circleImageView, View circleImageViewBg,
      ConstraintLayout clBioData, ScrollView constraintLayout, ImageView copyIcon,
      ImageView imgSpeakerToolbar, ImageView imgTwitter, LinearLayout llCards,
      ConstraintLayout rlSpeakerHandle, TextView sessionsLabel, TextView textView,
      TextView tvSpeakerBio, TextView tvSpeakerBioLabel, TextView tvSpeakerCompany,
      TextView tvSpeakerHandle, TextView tvSpeakerName, TextView tvSpeakerRole,
      TextView tvTopTwitterHandle, TextView tvTwitterHandleLabel, Guideline verticalGuideline) {
    super(_bindingComponent, _root, _localFieldCount);
    this.circleImageView = circleImageView;
    this.circleImageViewBg = circleImageViewBg;
    this.clBioData = clBioData;
    this.constraintLayout = constraintLayout;
    this.copyIcon = copyIcon;
    this.imgSpeakerToolbar = imgSpeakerToolbar;
    this.imgTwitter = imgTwitter;
    this.llCards = llCards;
    this.rlSpeakerHandle = rlSpeakerHandle;
    this.sessionsLabel = sessionsLabel;
    this.textView = textView;
    this.tvSpeakerBio = tvSpeakerBio;
    this.tvSpeakerBioLabel = tvSpeakerBioLabel;
    this.tvSpeakerCompany = tvSpeakerCompany;
    this.tvSpeakerHandle = tvSpeakerHandle;
    this.tvSpeakerName = tvSpeakerName;
    this.tvSpeakerRole = tvSpeakerRole;
    this.tvTopTwitterHandle = tvTopTwitterHandle;
    this.tvTwitterHandleLabel = tvTwitterHandleLabel;
    this.verticalGuideline = verticalGuideline;
  }

  public abstract void setSpeaker(@Nullable Speaker speaker);

  @Nullable
  public Speaker getSpeaker() {
    return mSpeaker;
  }

  @NonNull
  public static FragmentSpeakerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_speaker_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSpeakerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSpeakerDetailsBinding>inflateInternal(inflater, R.layout.fragment_speaker_details, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSpeakerDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_speaker_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSpeakerDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSpeakerDetailsBinding>inflateInternal(inflater, R.layout.fragment_speaker_details, null, false, component);
  }

  public static FragmentSpeakerDetailsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSpeakerDetailsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSpeakerDetailsBinding)bind(component, view, R.layout.fragment_speaker_details);
  }
}
