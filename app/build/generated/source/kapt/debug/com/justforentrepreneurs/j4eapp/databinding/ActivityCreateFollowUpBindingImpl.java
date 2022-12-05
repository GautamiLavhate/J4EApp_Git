package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateFollowUpBindingImpl extends ActivityCreateFollowUpBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(20);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_lead_status_publish"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.radiogroup, 3);
        sViewsWithIds.put(R.id.radioone, 4);
        sViewsWithIds.put(R.id.radiotwo, 5);
        sViewsWithIds.put(R.id.llCategorySelection, 6);
        sViewsWithIds.put(R.id.tvCategory, 7);
        sViewsWithIds.put(R.id.crossfun, 8);
        sViewsWithIds.put(R.id.ivDropDown, 9);
        sViewsWithIds.put(R.id.ivDropUp, 10);
        sViewsWithIds.put(R.id.rvCategory, 11);
        sViewsWithIds.put(R.id.llCategorySelection2, 12);
        sViewsWithIds.put(R.id.tvCategory2, 13);
        sViewsWithIds.put(R.id.ivDropDown2, 14);
        sViewsWithIds.put(R.id.ivDropUp2, 15);
        sViewsWithIds.put(R.id.rvCategory2, 16);
        sViewsWithIds.put(R.id.edtUserName, 17);
        sViewsWithIds.put(R.id.edtdescription, 18);
        sViewsWithIds.put(R.id.edtDate, 19);
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

    public ActivityCreateFollowUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityCreateFollowUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[18]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.RadioGroup) bindings[3]
            , (android.widget.RadioButton) bindings[4]
            , (android.widget.RadioButton) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding) bindings[2]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[13]
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