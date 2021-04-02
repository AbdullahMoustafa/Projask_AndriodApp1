package com.zedan.acare.supervisor.ui.profile;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/zedan/acare/supervisor/ui/profile/ProfileViewModel$supervisorListener$1", "Lcom/google/firebase/database/ValueEventListener;", "onCancelled", "", "error", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "snapshot", "Lcom/google/firebase/database/DataSnapshot;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel$supervisorListener$1 implements ValueEventListener {
    ProfileViewModel$supervisorListener$1() {
    }

    public void onDataChange(DataSnapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
    }

    public void onCancelled(DatabaseError error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }
}
