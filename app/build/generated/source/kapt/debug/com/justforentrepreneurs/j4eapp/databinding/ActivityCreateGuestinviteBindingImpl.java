package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateGuestinviteBindingImpl extends ActivityCreateGuestinviteBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(27);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_lead_status_publish"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layoutmanager, 3);
        sViewsWithIds.put(R.id.edtGuest, 4);
        sViewsWithIds.put(R.id.llCategorySelection3, 5);
        sViewsWithIds.put(R.id.llCategorySelection1, 6);
        sViewsWithIds.put(R.id.tvCategory1, 7);
        sViewsWithIds.put(R.id.crossfun, 8);
        sViewsWithIds.put(R.id.ivDropDown1, 9);
        sViewsWithIds.put(R.id.ivDropUp1, 10);
        sViewsWithIds.put(R.id.rvCategory1, 11);
        sViewsWithIds.put(R.id.edtphonenumber, 12);
        sViewsWithIds.put(R.id.checkbtd, 13);
        sViewsWithIds.put(R.id.paymentbyli, 14);
        sViewsWithIds.put(R.id.llCategorySelection2, 15);
        sViewsWithIds.put(R.id.tvCategory2, 16);
        sViewsWithIds.put(R.id.ivDropDown2, 17);
        sViewsWithIds.put(R.id.ivDropUp2, 18);
        sViewsWithIds.put(R.id.rvCategory2, 19);
        sViewsWithIds.put(R.id.edtEntryfees, 20);
        sViewsWithIds.put(R.id.edtemailid, 21);
        sViewsWithIds.put(R.id.edtdesignation, 22);
        sViewsWithIds.put(R.id.edtcompanyname, 23);
        sViewsWithIds.put(R.id.makepayment, 24);
        sViewsWithIds.put(R.id.invitedPeople, 25);
        sViewsWithIds.put(R.id.layoutmanager1, 26);
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

    public ActivityCreateGuestinviteBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private ActivityCreateGuestinviteBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[13]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.EditText) bindings[20]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[23]
            , (android.widget.EditText) bindings[22]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[12]
            , (android.widget.TextView) bindings[25]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[24]
            , (android.widget.LinearLayout) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding) bindings[2]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[16]
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