package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DrawerLayoutBindingImpl extends DrawerLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(24);
        sIncludes.setIncludes(1, 
            new String[] {"lav_my_diary", "lav_deals_discounts"},
            new int[] {2, 3},
            new int[] {com.justforentrepreneurs.j4eapp.R.layout.lav_my_diary,
                com.justforentrepreneurs.j4eapp.R.layout.lav_deals_discounts});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ivProfileImg, 4);
        sViewsWithIds.put(R.id.fullname, 5);
        sViewsWithIds.put(R.id.tvViewProfile, 6);
        sViewsWithIds.put(R.id.llSetting, 7);
        sViewsWithIds.put(R.id.llHome, 8);
        sViewsWithIds.put(R.id.llMyDiary, 9);
        sViewsWithIds.put(R.id.ivDropDownDiary, 10);
        sViewsWithIds.put(R.id.llDealsDiscounts, 11);
        sViewsWithIds.put(R.id.ivDropDownDeals, 12);
        sViewsWithIds.put(R.id.llAllLeads, 13);
        sViewsWithIds.put(R.id.llAllPosts, 14);
        sViewsWithIds.put(R.id.llAllEvents, 15);
        sViewsWithIds.put(R.id.llAllRecognition, 16);
        sViewsWithIds.put(R.id.llTopRanking, 17);
        sViewsWithIds.put(R.id.llJ4EMembers, 18);
        sViewsWithIds.put(R.id.llShareApp, 19);
        sViewsWithIds.put(R.id.llSupportFeedback, 20);
        sViewsWithIds.put(R.id.llTermsAndCondition, 21);
        sViewsWithIds.put(R.id.llPrivacyPolicy, 22);
        sViewsWithIds.put(R.id.llAboutUs, 23);
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

    public DrawerLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private DrawerLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[10]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (com.justforentrepreneurs.j4eapp.databinding.LavDealsDiscountsBinding) bindings[3]
            , (com.justforentrepreneurs.j4eapp.databinding.LavMyDiaryBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.TextView) bindings[6]
            );
        setContainedBinding(this.layDealsDiscount);
        setContainedBinding(this.layMyDiary);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        layMyDiary.invalidateAll();
        layDealsDiscount.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (layMyDiary.hasPendingBindings()) {
            return true;
        }
        if (layDealsDiscount.hasPendingBindings()) {
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
        layMyDiary.setLifecycleOwner(lifecycleOwner);
        layDealsDiscount.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLayDealsDiscount((com.justforentrepreneurs.j4eapp.databinding.LavDealsDiscountsBinding) object, fieldId);
            case 1 :
                return onChangeLayMyDiary((com.justforentrepreneurs.j4eapp.databinding.LavMyDiaryBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLayDealsDiscount(com.justforentrepreneurs.j4eapp.databinding.LavDealsDiscountsBinding LayDealsDiscount, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayMyDiary(com.justforentrepreneurs.j4eapp.databinding.LavMyDiaryBinding LayMyDiary, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        executeBindingsOn(layMyDiary);
        executeBindingsOn(layDealsDiscount);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): layDealsDiscount
        flag 1 (0x2L): layMyDiary
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}