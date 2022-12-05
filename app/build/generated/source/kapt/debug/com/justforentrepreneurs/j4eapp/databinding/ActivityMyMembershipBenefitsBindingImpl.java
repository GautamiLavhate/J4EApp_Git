package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyMembershipBenefitsBindingImpl extends ActivityMyMembershipBenefitsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(24);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_edit"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_edit});
        sIncludes.setIncludes(2, 
            new String[] {"ab_membershipbenefit"},
            new int[] {4},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_membershipbenefit});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 5);
        sViewsWithIds.put(R.id.ivProduct, 6);
        sViewsWithIds.put(R.id.fullnametv, 7);
        sViewsWithIds.put(R.id.dob, 8);
        sViewsWithIds.put(R.id.designation, 9);
        sViewsWithIds.put(R.id.mobilenumber, 10);
        sViewsWithIds.put(R.id.ll, 11);
        sViewsWithIds.put(R.id.Validdate, 12);
        sViewsWithIds.put(R.id.tvUpgrade, 13);
        sViewsWithIds.put(R.id.llPlan, 14);
        sViewsWithIds.put(R.id.Membershiptitle, 15);
        sViewsWithIds.put(R.id.benefitstv, 16);
        sViewsWithIds.put(R.id.caostmb, 17);
        sViewsWithIds.put(R.id.baseicmember, 18);
        sViewsWithIds.put(R.id.recyclerFeatues, 19);
        sViewsWithIds.put(R.id.txtReferralCode, 20);
        sViewsWithIds.put(R.id.imgCopy, 21);
        sViewsWithIds.put(R.id.Upgrade, 22);
        sViewsWithIds.put(R.id.Renew, 23);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbMembershipbenefitBinding mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyMembershipBenefitsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private ActivityMyMembershipBenefitsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[15]
            , (android.widget.Button) bindings[23]
            , (android.widget.Button) bindings[22]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.TextView) bindings[10]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditBinding) bindings[3]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[20]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.justforentrepreneurs.j4eapp.databinding.AbMembershipbenefitBinding) bindings[4];
        setContainedBinding(this.mboundView2);
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
        mboundView2.invalidateAll();
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
        if (mboundView2.hasPendingBindings()) {
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
        mboundView2.setLifecycleOwner(lifecycleOwner);
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
        executeBindingsOn(mboundView2);
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