package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyLeadsStatusListBindingImpl extends ActivityMyLeadsStatusListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(0, 
            new String[] {"lay_toolbar_lead_status_add"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_add});
        sIncludes.setIncludes(1, 
            new String[] {"ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist", "ab_leadsstatuslist"},
            new int[] {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist,
                com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvStatuslead, 15);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView11;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView110;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView111;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView12;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView13;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView14;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView15;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView16;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView17;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView18;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding mboundView19;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyLeadsStatusListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityMyLeadsStatusListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[15]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusAddBinding) bindings[2]
            );
        this.abStatuslead.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[3];
        setContainedBinding(this.mboundView1);
        this.mboundView11 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[4];
        setContainedBinding(this.mboundView11);
        this.mboundView110 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[13];
        setContainedBinding(this.mboundView110);
        this.mboundView111 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[14];
        setContainedBinding(this.mboundView111);
        this.mboundView12 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[5];
        setContainedBinding(this.mboundView12);
        this.mboundView13 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[6];
        setContainedBinding(this.mboundView13);
        this.mboundView14 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[7];
        setContainedBinding(this.mboundView14);
        this.mboundView15 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[8];
        setContainedBinding(this.mboundView15);
        this.mboundView16 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[9];
        setContainedBinding(this.mboundView16);
        this.mboundView17 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[10];
        setContainedBinding(this.mboundView17);
        this.mboundView18 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[11];
        setContainedBinding(this.mboundView18);
        this.mboundView19 = (com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBinding) bindings[12];
        setContainedBinding(this.mboundView19);
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
        mboundView12.invalidateAll();
        mboundView13.invalidateAll();
        mboundView14.invalidateAll();
        mboundView15.invalidateAll();
        mboundView16.invalidateAll();
        mboundView17.invalidateAll();
        mboundView18.invalidateAll();
        mboundView19.invalidateAll();
        mboundView110.invalidateAll();
        mboundView111.invalidateAll();
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
        if (mboundView12.hasPendingBindings()) {
            return true;
        }
        if (mboundView13.hasPendingBindings()) {
            return true;
        }
        if (mboundView14.hasPendingBindings()) {
            return true;
        }
        if (mboundView15.hasPendingBindings()) {
            return true;
        }
        if (mboundView16.hasPendingBindings()) {
            return true;
        }
        if (mboundView17.hasPendingBindings()) {
            return true;
        }
        if (mboundView18.hasPendingBindings()) {
            return true;
        }
        if (mboundView19.hasPendingBindings()) {
            return true;
        }
        if (mboundView110.hasPendingBindings()) {
            return true;
        }
        if (mboundView111.hasPendingBindings()) {
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
        mboundView12.setLifecycleOwner(lifecycleOwner);
        mboundView13.setLifecycleOwner(lifecycleOwner);
        mboundView14.setLifecycleOwner(lifecycleOwner);
        mboundView15.setLifecycleOwner(lifecycleOwner);
        mboundView16.setLifecycleOwner(lifecycleOwner);
        mboundView17.setLifecycleOwner(lifecycleOwner);
        mboundView18.setLifecycleOwner(lifecycleOwner);
        mboundView19.setLifecycleOwner(lifecycleOwner);
        mboundView110.setLifecycleOwner(lifecycleOwner);
        mboundView111.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusAddBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusAddBinding Toolbar, int fieldId) {
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
        executeBindingsOn(mboundView12);
        executeBindingsOn(mboundView13);
        executeBindingsOn(mboundView14);
        executeBindingsOn(mboundView15);
        executeBindingsOn(mboundView16);
        executeBindingsOn(mboundView17);
        executeBindingsOn(mboundView18);
        executeBindingsOn(mboundView19);
        executeBindingsOn(mboundView110);
        executeBindingsOn(mboundView111);
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