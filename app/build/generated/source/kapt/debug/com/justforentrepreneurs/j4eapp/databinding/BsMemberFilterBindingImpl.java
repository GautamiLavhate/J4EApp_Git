package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class BsMemberFilterBindingImpl extends BsMemberFilterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(35);
        sIncludes.setIncludes(1, 
            new String[] {"ab_memberfilters"},
            new int[] {2},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.ab_memberfilters});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.clearall, 3);
        sViewsWithIds.put(R.id.ivClose, 4);
        sViewsWithIds.put(R.id.linearlayout, 5);
        sViewsWithIds.put(R.id.llTypeMembership, 6);
        sViewsWithIds.put(R.id.recyclerplan, 7);
        sViewsWithIds.put(R.id.llCategory, 8);
        sViewsWithIds.put(R.id.llCategorySelection, 9);
        sViewsWithIds.put(R.id.tvCategory, 10);
        sViewsWithIds.put(R.id.crossfun, 11);
        sViewsWithIds.put(R.id.ivDropDown, 12);
        sViewsWithIds.put(R.id.ivDropUp, 13);
        sViewsWithIds.put(R.id.rvCategory, 14);
        sViewsWithIds.put(R.id.llCategorySelection1, 15);
        sViewsWithIds.put(R.id.tvCategory1, 16);
        sViewsWithIds.put(R.id.ivDropDown1, 17);
        sViewsWithIds.put(R.id.ivDropUp1, 18);
        sViewsWithIds.put(R.id.rvCategory1, 19);
        sViewsWithIds.put(R.id.llNoOfEmployees, 20);
        sViewsWithIds.put(R.id.llCategorySelection2, 21);
        sViewsWithIds.put(R.id.tvCategory2, 22);
        sViewsWithIds.put(R.id.ivDropDown2, 23);
        sViewsWithIds.put(R.id.ivDropUp2, 24);
        sViewsWithIds.put(R.id.rvCategory2, 25);
        sViewsWithIds.put(R.id.llRank, 26);
        sViewsWithIds.put(R.id.top10, 27);
        sViewsWithIds.put(R.id.top100, 28);
        sViewsWithIds.put(R.id.top500, 29);
        sViewsWithIds.put(R.id.top5000, 30);
        sViewsWithIds.put(R.id.llLocation, 31);
        sViewsWithIds.put(R.id.editlocation, 32);
        sViewsWithIds.put(R.id.clearloctaion, 33);
        sViewsWithIds.put(R.id.tvApplyFilter, 34);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @Nullable
    private final com.justforentrepreneurs.j4eapp.databinding.AbMemberfiltersBinding mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public BsMemberFilterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }
    private BsMemberFilterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[33]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.EditText) bindings[32]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[23]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[24]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.LinearLayout) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (androidx.recyclerview.widget.RecyclerView) bindings[25]
            , (android.widget.RadioButton) bindings[27]
            , (android.widget.RadioButton) bindings[28]
            , (android.widget.RadioButton) bindings[29]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.TextView) bindings[34]
            , (android.widget.EditText) bindings[10]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[22]
            );
        this.linearlayout1.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.justforentrepreneurs.j4eapp.databinding.AbMemberfiltersBinding) bindings[2];
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