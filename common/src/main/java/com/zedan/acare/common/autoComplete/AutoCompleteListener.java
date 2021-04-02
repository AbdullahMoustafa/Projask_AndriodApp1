package com.zedan.acare.common.autoComplete;

import androidx.annotation.NonNull;

import com.zedan.acare.common.entities.SelectEntity;

public interface AutoCompleteListener {
    void onSelected(@NonNull SelectEntity selectEntity);

}
