package com.zedan.acare.supervisor.ui.tasks;

import android.view.View;
import androidx.navigation.fragment.FragmentKt;
import com.zedan.acare.supervisor.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: TasksFragment.kt */
final class TasksFragment$setViewsListener$2 implements View.OnClickListener {
    final /* synthetic */ TasksFragment this$0;

    TasksFragment$setViewsListener$2(TasksFragment tasksFragment) {
        this.this$0 = tasksFragment;
    }

    public final void onClick(View it) {
        FragmentKt.findNavController(this.this$0).navigate((int) R.id.action_tasksFragment_to_profileFragment);
    }
}
