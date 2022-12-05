package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainJ4eBindingImpl extends ActivityMainJ4eBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(1, 
            new String[] {"lay_toolbar_home", "lay_bottom_bar"},
            new int[] {3, 4},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_home,
                com.justforentrepreneurs.j4eapp.R.layout.lay_bottom_bar});
        sIncludes.setIncludes(2, 
            new String[] {"drawer_layout"},
            new int[] {5},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.drawer_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fragment_container, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainJ4eBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityMainJ4eBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.justforentrepreneurs.j4eapp.databinding.LayBottomBarBinding) bindings[4]
            , (com.justforentrepreneurs.j4eapp.databinding.DrawerLayoutBinding) bindings[5]
            , (androidx.drawerlayout.widget.DrawerLayout) bindings[0]
            , (com.google.android.material.circularreveal.CircularRevealFrameLayout) bindings[6]
            , (com.google.android.material.navigation.NavigationView) bindings[2]
            , (com.justforentrepreneurs.j4eapp.databinding.LayToolbarHomeBinding) bindings[3]
            );
        setContainedBinding(this.bottomBar);
        setContainedBinding(this.drawer);
        this.drawerLayout.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.navView.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        toolbar.invalidateAll();
        bottomBar.invalidateAll();
        drawer.invalidateAll();
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
        if (bottomBar.hasPendingBindings()) {
            return true;
        }
        if (drawer.hasPendingBindings()) {
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
        bottomBar.setLifecycleOwner(lifecycleOwner);
        drawer.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBottomBar((com.justforentrepreneurs.j4eapp.databinding.LayBottomBarBinding) object, fieldId);
            case 1 :
                return onChangeDrawer((com.justforentrepreneurs.j4eapp.databinding.DrawerLayoutBinding) object, fieldId);
            case 2 :
                return onChangeToolbar((com.justforentrepreneurs.j4eapp.databinding.LayToolbarHomeBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBottomBar(com.justforentrepreneurs.j4eapp.databinding.LayBottomBarBinding BottomBar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeDrawer(com.justforentrepreneurs.j4eapp.databinding.DrawerLayoutBinding Drawer, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(com.justforentrepreneurs.j4eapp.databinding.LayToolbarHomeBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        executeBindingsOn(bottomBar);
        executeBindingsOn(drawer);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): bottomBar
        flag 1 (0x2L): drawer
        flag 2 (0x3L): toolbar
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}