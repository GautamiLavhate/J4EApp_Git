package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCreateReferralBindingImpl extends ActivityCreateReferralBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(50);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_lead_status_publish"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 3);
        sViewsWithIds.put(R.id.llCategorySelectionReferralFor, 4);
        sViewsWithIds.put(R.id.tvCategoryReferralFor, 5);
        sViewsWithIds.put(R.id.crossReffral, 6);
        sViewsWithIds.put(R.id.ivDropDownReferralFor, 7);
        sViewsWithIds.put(R.id.ivDropUpReferralFor, 8);
        sViewsWithIds.put(R.id.rvCategoryReferralFor, 9);
        sViewsWithIds.put(R.id.llTypeMembership, 10);
        sViewsWithIds.put(R.id.myself, 11);
        sViewsWithIds.put(R.id.inside, 12);
        sViewsWithIds.put(R.id.Outside, 13);
        sViewsWithIds.put(R.id.Givercover, 14);
        sViewsWithIds.put(R.id.changetext, 15);
        sViewsWithIds.put(R.id.edtTitle, 16);
        sViewsWithIds.put(R.id.edtFeedback, 17);
        sViewsWithIds.put(R.id.llCategorySelectionfun, 18);
        sViewsWithIds.put(R.id.tvCategoryfun, 19);
        sViewsWithIds.put(R.id.crossfun, 20);
        sViewsWithIds.put(R.id.ivDropDownfun, 21);
        sViewsWithIds.put(R.id.ivDropUpfun, 22);
        sViewsWithIds.put(R.id.rvCategoryfun, 23);
        sViewsWithIds.put(R.id.reclercateid, 24);
        sViewsWithIds.put(R.id.ContactPersontvt, 25);
        sViewsWithIds.put(R.id.listkbbflist, 26);
        sViewsWithIds.put(R.id.llCategorySelectionContact, 27);
        sViewsWithIds.put(R.id.tvCategoryContact, 28);
        sViewsWithIds.put(R.id.crossContact, 29);
        sViewsWithIds.put(R.id.ivDropDownContact, 30);
        sViewsWithIds.put(R.id.ivDropUpContact, 31);
        sViewsWithIds.put(R.id.rvCategoryContact, 32);
        sViewsWithIds.put(R.id.outsideli, 33);
        sViewsWithIds.put(R.id.edtname, 34);
        sViewsWithIds.put(R.id.edtcomename, 35);
        sViewsWithIds.put(R.id.edtdesignation, 36);
        sViewsWithIds.put(R.id.edtMobileNumber, 37);
        sViewsWithIds.put(R.id.imgOpenContact, 38);
        sViewsWithIds.put(R.id.edtStdCode, 39);
        sViewsWithIds.put(R.id.edtLandlineNumber, 40);
        sViewsWithIds.put(R.id.wahtasap, 41);
        sViewsWithIds.put(R.id.edtemailid, 42);
        sViewsWithIds.put(R.id.edtAddress, 43);
        sViewsWithIds.put(R.id.radio1, 44);
        sViewsWithIds.put(R.id.radio2, 45);
        sViewsWithIds.put(R.id.radio3, 46);
        sViewsWithIds.put(R.id.radio4, 47);
        sViewsWithIds.put(R.id.radio5, 48);
        sViewsWithIds.put(R.id.linearlayout1, 49);
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

    public ActivityCreateReferralBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 50, sIncludes, sViewsWithIds));
    }
    private ActivityCreateReferralBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[25]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[29]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.EditText) bindings[43]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[40]
            , (android.widget.EditText) bindings[37]
            , (android.widget.EditText) bindings[39]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[35]
            , (android.widget.EditText) bindings[36]
            , (android.widget.EditText) bindings[42]
            , (android.widget.EditText) bindings[34]
            , (android.widget.ImageView) bindings[38]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.ImageView) bindings[30]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[31]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[49]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.RadioButton) bindings[11]
            , (android.widget.LinearLayout) bindings[33]
            , (android.widget.RadioButton) bindings[44]
            , (android.widget.RadioButton) bindings[45]
            , (android.widget.RadioButton) bindings[46]
            , (android.widget.RadioButton) bindings[47]
            , (android.widget.RadioButton) bindings[48]
            , (androidx.recyclerview.widget.RecyclerView) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[32]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBinding) bindings[2]
            , (android.widget.EditText) bindings[28]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[19]
            , (android.widget.EditText) bindings[41]
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