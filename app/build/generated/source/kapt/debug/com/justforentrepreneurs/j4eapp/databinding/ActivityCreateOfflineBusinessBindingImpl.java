package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateOfflineBusinessBindingImpl extends ActivityCreateOfflineBusinessBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(17);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_lead_status_publish"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 3);
        sViewsWithIds.put(R.id.radioGrp, 4);
        sViewsWithIds.put(R.id.llCategorySelection, 5);
        sViewsWithIds.put(R.id.tvCategory, 6);
        sViewsWithIds.put(R.id.crossfun, 7);
        sViewsWithIds.put(R.id.ivDropDown, 8);
        sViewsWithIds.put(R.id.ivDropUp, 9);
        sViewsWithIds.put(R.id.rvCategory, 10);
        sViewsWithIds.put(R.id.edtTitle, 11);
        sViewsWithIds.put(R.id.edtServiceName, 12);
        sViewsWithIds.put(R.id.edtDate, 13);
        sViewsWithIds.put(R.id.edtPrice, 14);
        sViewsWithIds.put(R.id.edtRemarks, 15);
        sViewsWithIds.put(R.id.linearlayout1, 16);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCreateOfflineBusinessBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private ActivityCreateOfflineBusinessBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[13]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[15]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[11]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.RadioGroup) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding) bindings[2]
            , (android.widget.EditText) bindings[6]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}