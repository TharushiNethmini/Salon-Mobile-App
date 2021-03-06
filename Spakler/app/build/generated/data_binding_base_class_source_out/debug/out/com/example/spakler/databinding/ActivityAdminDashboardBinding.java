// Generated by view binder compiler. Do not edit!
package com.example.spakler.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.spakler.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminDashboardBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RelativeLayout addEmployee;

  @NonNull
  public final RelativeLayout allEmployee;

  @NonNull
  public final ImageView hello;

  private ActivityAdminDashboardBinding(@NonNull LinearLayout rootView,
      @NonNull RelativeLayout addEmployee, @NonNull RelativeLayout allEmployee,
      @NonNull ImageView hello) {
    this.rootView = rootView;
    this.addEmployee = addEmployee;
    this.allEmployee = allEmployee;
    this.hello = hello;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addEmployee;
      RelativeLayout addEmployee = ViewBindings.findChildViewById(rootView, id);
      if (addEmployee == null) {
        break missingId;
      }

      id = R.id.allEmployee;
      RelativeLayout allEmployee = ViewBindings.findChildViewById(rootView, id);
      if (allEmployee == null) {
        break missingId;
      }

      id = R.id.hello;
      ImageView hello = ViewBindings.findChildViewById(rootView, id);
      if (hello == null) {
        break missingId;
      }

      return new ActivityAdminDashboardBinding((LinearLayout) rootView, addEmployee, allEmployee,
          hello);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
