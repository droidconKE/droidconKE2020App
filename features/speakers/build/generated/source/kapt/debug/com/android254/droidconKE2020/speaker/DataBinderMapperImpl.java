package com.android254.droidconKE2020.speaker;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakerDetailsBindingImpl;
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBindingImpl;
import com.android254.droidconKE2020.speaker.databinding.FragmentSpeakersBindingLandImpl;
import com.android254.droidconKE2020.speaker.databinding.ItemSpeakerBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTSPEAKERDETAILS = 1;

  private static final int LAYOUT_FRAGMENTSPEAKERS = 2;

  private static final int LAYOUT_ITEMSPEAKER = 3;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(3);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android254.droidconKE2020.speaker.R.layout.fragment_speaker_details, LAYOUT_FRAGMENTSPEAKERDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android254.droidconKE2020.speaker.R.layout.fragment_speakers, LAYOUT_FRAGMENTSPEAKERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android254.droidconKE2020.speaker.R.layout.item_speaker, LAYOUT_ITEMSPEAKER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTSPEAKERDETAILS: {
          if ("layout/fragment_speaker_details_0".equals(tag)) {
            return new FragmentSpeakerDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_speaker_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPEAKERS: {
          if ("layout/fragment_speakers_0".equals(tag)) {
            return new FragmentSpeakersBindingImpl(component, view);
          }
          if ("layout-land/fragment_speakers_0".equals(tag)) {
            return new FragmentSpeakersBindingLandImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_speakers is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSPEAKER: {
          if ("layout/item_speaker_0".equals(tag)) {
            return new ItemSpeakerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_speaker is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(0);
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(0, "_all");
      sKeys.put(7929856, "clearSearch");
      sKeys.put(7929857, "goBack");
      sKeys.put(7929858, "initiateEasterEgg");
      sKeys.put(7929859, "isLoggedIn");
      sKeys.put(7929860, "openProfile");
      sKeys.put(7929861, "openSpeakerDetails");
      sKeys.put(7929862, "speaker");
      sKeys.put(7929863, "speakersViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/fragment_speaker_details_0", com.android254.droidconKE2020.speaker.R.layout.fragment_speaker_details);
      sKeys.put("layout/fragment_speakers_0", com.android254.droidconKE2020.speaker.R.layout.fragment_speakers);
      sKeys.put("layout-land/fragment_speakers_0", com.android254.droidconKE2020.speaker.R.layout.fragment_speakers);
      sKeys.put("layout/item_speaker_0", com.android254.droidconKE2020.speaker.R.layout.item_speaker);
    }
  }
}
