// Generated by view binder compiler. Do not edit!
package com.example.spakler.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.spakler.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SinglerowstylistsBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView t1;

  @NonNull
  public final TextView t2;

  private SinglerowstylistsBinding(@NonNull CardView rootView, @NonNull TextView t1,
      @NonNull TextView t2) {
    this.rootView = rootView;
    this.t1 = t1;
    this.t2 = t2;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static SinglerowstylistsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SinglerowstylistsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.singlerowstylists, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SinglerowstylistsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.t1;
      TextView t1 = ViewBindings.findChildViewById(rootView, id);
      if (t1 == null) {
        break missingId;
      }

      id = R.id.t2;
      TextView t2 = ViewBindings.findChildViewById(rootView, id);
      if (t2 == null) {
        break missingId;
      }

      return new SinglerowstylistsBinding((CardView) rootView, t1, t2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
