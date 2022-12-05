package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayProfileAboutUsBindingImpl extends LayProfileAboutUsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvAboutCompany, 1);
        sViewsWithIds.put(R.id.tvCompanyName, 2);
        sViewsWithIds.put(R.id.tvBusinessEntity, 3);
        sViewsWithIds.put(R.id.tvBusinessType, 4);
        sViewsWithIds.put(R.id.tvBusinessExpertise, 5);
        sViewsWithIds.put(R.id.tvWorkingForm, 6);
        sViewsWithIds.put(R.id.tvNoOfEmployee, 7);
        sViewsWithIds.put(R.id.tvExpectedTurnOver, 8);
        sViewsWithIds.put(R.id.tvTagetAudience, 9);
        sViewsWithIds.put(R.id.tvTypeofMembership, 10);
        sViewsWithIds.put(R.id.companybouchaer, 11);
        sViewsWithIds.put(R.id.companybouchaeron, 12);
        sViewsWithIds.put(R.id.ivImgPdf, 13);
        sViewsWithIds.put(R.id.companybouchaerPpt, 14);
        sViewsWithIds.put(R.id.companybouchaeronPpt, 15);
        sViewsWithIds.put(R.id.ivImgPpt, 16);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayProfileAboutUsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private LayProfileAboutUsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[14]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}