package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMyBuddiesBindingImpl extends ActivityMyBuddiesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(20);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar"},
            new int[] {3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar});
        sIncludes.setIncludes(2, 
            new String[] {"ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout", "ab_buddieslayout"},
            new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout,
                com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rvAllBuddies, 16);
        sViewsWithIds.put(R.id.NoLeadInvited, 17);
        sViewsWithIds.put(R.id.default_text, 18);
        sViewsWithIds.put(R.id.ivFilter, 19);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView2;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView21;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView210;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView211;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView22;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView23;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView24;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView25;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView26;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView27;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView28;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding mboundView29;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMyBuddiesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityMyBuddiesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (com.google.android.material.floatingactionbutton.FloatingActionButton) bindings[19]
            , (android.widget.LinearLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) bindings[3]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[4];
        setContainedBinding(this.mboundView2);
        this.mboundView21 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[5];
        setContainedBinding(this.mboundView21);
        this.mboundView210 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[14];
        setContainedBinding(this.mboundView210);
        this.mboundView211 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[15];
        setContainedBinding(this.mboundView211);
        this.mboundView22 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[6];
        setContainedBinding(this.mboundView22);
        this.mboundView23 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[7];
        setContainedBinding(this.mboundView23);
        this.mboundView24 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[8];
        setContainedBinding(this.mboundView24);
        this.mboundView25 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[9];
        setContainedBinding(this.mboundView25);
        this.mboundView26 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[10];
        setContainedBinding(this.mboundView26);
        this.mboundView27 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[11];
        setContainedBinding(this.mboundView27);
        this.mboundView28 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[12];
        setContainedBinding(this.mboundView28);
        this.mboundView29 = (com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBinding) bindings[13];
        setContainedBinding(this.mboundView29);
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
        mboundView21.invalidateAll();
        mboundView22.invalidateAll();
        mboundView23.invalidateAll();
        mboundView24.invalidateAll();
        mboundView25.invalidateAll();
        mboundView26.invalidateAll();
        mboundView27.invalidateAll();
        mboundView28.invalidateAll();
        mboundView29.invalidateAll();
        mboundView210.invalidateAll();
        mboundView211.invalidateAll();
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
        if (mboundView21.hasPendingBindings()) {
            return true;
        }
        if (mboundView22.hasPendingBindings()) {
            return true;
        }
        if (mboundView23.hasPendingBindings()) {
            return true;
        }
        if (mboundView24.hasPendingBindings()) {
            return true;
        }
        if (mboundView25.hasPendingBindings()) {
            return true;
        }
        if (mboundView26.hasPendingBindings()) {
            return true;
        }
        if (mboundView27.hasPendingBindings()) {
            return true;
        }
        if (mboundView28.hasPendingBindings()) {
            return true;
        }
        if (mboundView29.hasPendingBindings()) {
            return true;
        }
        if (mboundView210.hasPendingBindings()) {
            return true;
        }
        if (mboundView211.hasPendingBindings()) {
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
        mboundView21.setLifecycleOwner(lifecycleOwner);
        mboundView22.setLifecycleOwner(lifecycleOwner);
        mboundView23.setLifecycleOwner(lifecycleOwner);
        mboundView24.setLifecycleOwner(lifecycleOwner);
        mboundView25.setLifecycleOwner(lifecycleOwner);
        mboundView26.setLifecycleOwner(lifecycleOwner);
        mboundView27.setLifecycleOwner(lifecycleOwner);
        mboundView28.setLifecycleOwner(lifecycleOwner);
        mboundView29.setLifecycleOwner(lifecycleOwner);
        mboundView210.setLifecycleOwner(lifecycleOwner);
        mboundView211.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarBinding Toolbar, int fieldId) {
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
        executeBindingsOn(mboundView21);
        executeBindingsOn(mboundView22);
        executeBindingsOn(mboundView23);
        executeBindingsOn(mboundView24);
        executeBindingsOn(mboundView25);
        executeBindingsOn(mboundView26);
        executeBindingsOn(mboundView27);
        executeBindingsOn(mboundView28);
        executeBindingsOn(mboundView29);
        executeBindingsOn(mboundView210);
        executeBindingsOn(mboundView211);
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