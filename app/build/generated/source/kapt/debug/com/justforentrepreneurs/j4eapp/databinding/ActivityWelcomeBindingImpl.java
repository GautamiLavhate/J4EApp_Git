package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityWelcomeBindingImpl extends ActivityWelcomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(1, 
            new String[] {"ab_welcome"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_welcome});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rlMain, 3);
        sViewsWithIds.put(R.id.tvSkip, 4);
        sViewsWithIds.put(R.id.tagSkip, 5);
        sViewsWithIds.put(R.id.ivBottom, 6);
        sViewsWithIds.put(R.id.vpIntroSlider, 7);
        sViewsWithIds.put(R.id.indicatorLayout, 8);
        sViewsWithIds.put(R.id.ivNext, 9);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbWelcomeBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityWelcomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityWelcomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.IndicatorLayout) bindings[8]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.LinearLayout) bindings[4]
            , (androidx.viewpager2.widget.ViewPager2) bindings[7]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbWelcomeBinding) bindings[2];
        setContainedBinding(this.mboundView1);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        mboundView1.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView1.hasPendingBindings()) {
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
        mboundView1.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        executeBindingsOn(mboundView1);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}