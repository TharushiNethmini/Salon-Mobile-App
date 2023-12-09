package com.example.spakler.adapter_class;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spakler.R;
import com.example.spakler.model.AddSchedule;
import com.example.spakler.model.Employee;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class AllAppontmentListListAdapter extends FirebaseRecyclerAdapter<AddSchedule, AllAppontmentListListAdapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AllAppontmentListListAdapter(@NonNull FirebaseRecyclerOptions<AddSchedule> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AllAppontmentListListAdapter.myviewholder holder, @SuppressLint("RecyclerView") int position, @NonNull AddSchedule model) {
        holder.empID.setText(model.getScheduleID());
        holder.empFirstNAme.setText(model.getUserName());
        holder.empLastName.setText(model.getScheduleDate());
        holder.Nic.setText(model.getScheduleTime());
        holder.Contact.setText(model.getStylist());

    }

    @NonNull
    @Override
    public AllAppontmentListListAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowapponment, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView edit, delete;
        TextView empID, empFirstNAme, empLastName, Nic, Contact, Address;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            empID = (TextView) itemView.findViewById(R.id.t1);
            empFirstNAme = (TextView) itemView.findViewById(R.id.t2);
            empLastName = (TextView) itemView.findViewById(R.id.t3);
            Nic = (TextView) itemView.findViewById(R.id.t4);
            Contact = (TextView) itemView.findViewById(R.id.t5);
            Address = (TextView) itemView.findViewById(R.id.t6);

            edit = (TextView) itemView.findViewById(R.id.editicon);
            delete = (TextView) itemView.findViewById(R.id.deleteicon);
        }
    }

}