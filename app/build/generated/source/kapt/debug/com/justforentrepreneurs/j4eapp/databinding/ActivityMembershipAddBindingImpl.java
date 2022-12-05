package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMembershipAddBindingImpl extends ActivityMembershipAddBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(22);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_edit"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_edit});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lay, 3);
        sViewsWithIds.put(R.id.edtname, 4);
        sViewsWithIds.put(R.id.edtmiddle, 5);
        sViewsWithIds.put(R.id.edtlast, 6);
        sViewsWithIds.put(R.id.email, 7);
        sViewsWithIds.put(R.id.designationprofession, 8);
        sViewsWithIds.put(R.id.company_organisation, 9);
        sViewsWithIds.put(R.id.mobilenumber, 10);
        sViewsWithIds.put(R.id.edt_whatspp, 11);
        sViewsWithIds.put(R.id.edt_whatspp_business, 12);
        sViewsWithIds.put(R.id.officephone, 13);
        sViewsWithIds.put(R.id.address, 14);
        sViewsWithIds.put(R.id.referalcode, 15);
        sViewsWithIds.put(R.id.imgCorrect, 16);
        sViewsWithIds.put(R.id.imgIncorrect, 17);
        sViewsWithIds.put(R.id.txtValid, 18);
        sViewsWithIds.put(R.id.txtInValid, 19);
        sViewsWithIds.put(R.id.buy_plan, 20);
        sViewsWithIds.put(R.id.savemember, 21);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMembershipAddBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private ActivityMembershipAddBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.EditText) bindings[14]
            , (android.widget.TextView) bindings[20]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[12]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[7]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[15]
            , (android.widget.TextView) bindings[21]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditBinding) bindings[2]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[18]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
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
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditBinding Toolbar, int fieldId) {
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