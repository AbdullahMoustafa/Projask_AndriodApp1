package com.zedan.acare.supervisor.ui.profile;

import androidx.arch.core.util.Function;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\b\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "Y", "kotlin.jvm.PlatformType", "X", "it", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;", "androidx/lifecycle/TransformationsKt$map$1"}, k = 3, mv = {1, 4, 2})
/* compiled from: Transformations.kt */
public final class ProfileViewModel$$special$$inlined$map$5<I, O> implements Function<ProfileResult, ProfileResult.Error> {
    public final ProfileResult.Error apply(ProfileResult it) {
        ProfileResult it2 = it;
        if (it2 instanceof ProfileResult.Error) {
            return (ProfileResult.Error) it2;
        }
        return null;
    }
}
