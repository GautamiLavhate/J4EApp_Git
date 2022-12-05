package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityNewMyMembershipDetailsBindingImpl extends ActivityNewMyMembershipDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(13);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_simple"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.toolbar_simple});
        sIncludes.setIncludes(1, 
            new String[] {"ab_upgradepopupli", "ab_upgradepopupli"},
            new int[] {3, 4},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_upgradepopupli,
                com.justforentrepreneurs.j4eapp.R.layout.ab_upgradepopupli});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.linearlayout, 5);
        sViewsWithIds.put(R.id.crdAdv, 6);
        sViewsWithIds.put(R.id.imgAdv, 7);
        sViewsWithIds.put(R.id.allBenefits, 8);
        sViewsWithIds.put(R.id.txtSwipe, 9);
        sViewsWithIds.put(R.id.crdTitle, 10);
        sViewsWithIds.put(R.id.rvMembershipTitle, 11);
        sViewsWithIds.put(R.id.rvMembershipFeature, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbUpgradepopupliBinding mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbUpgradepopupliBinding mboundView11;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityNewMyMembershipDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityNewMyMembershipDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[10]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding) bindings[2]
            , (android.widget.TextView) bindings[9]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbUpgradepopupliBinding) bindings[3];
        setContainedBinding(this.mboundView1);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbUpgradepopupliBinding) bindings[4];
        setContainedBinding(this.mboundView11);
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
        mboundView1.invalidateAll();
        mboundView11.invalidateAll();
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
        if (mboundView1.hasPendingBindings()) {
            return true;
        }
        if (mboundView11.hasPendingBindings()) {
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
        mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBinding Toolbar, int fieldId) {
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
        executeBindingsOn(mboundView1);
        executeBindingsOn(mboundView11);
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