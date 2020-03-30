package com.android254.droidconKE2020.feed.ui.views

import android.app.Dialog
import android.os.Bundle
import com.android254.droidconKE2020.feed.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class RoundedBottomSheetFragment : BottomSheetDialogFragment() {
    override fun getTheme() = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme)
    }
}