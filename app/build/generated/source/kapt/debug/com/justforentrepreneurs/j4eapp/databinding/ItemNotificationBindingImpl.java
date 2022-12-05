package com.justforentrepreneurs.j4eapp.databinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemNotificationBindingImpl extends ItemNotificationBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.notificationImage, 1);
        sViewsWithIds.put(R.id.notificationText, 2);
        sViewsWithIds.put(R.id.date, 3);
        sViewsWithIds.put(R.id.leadtitle, 4);
        sViewsWithIds.put(R.id.reqByli, 5);
        sViewsWithIds.put(R.id.Byre, 6);
        sViewsWithIds.put(R.id.leadtitle2, 7);
        sViewsWithIds.put(R.id.udatedbyli, 8);
        sViewsWithIds.put(R.id.Updatedby, 9);
        sViewsWithIds.put(R.id.Updatedbyname, 10);
        sViewsWithIds.put(R.id.businesswithli, 11);
        sViewsWithIds.put(R.id.Businesswith, 12);
        sViewsWithIds.put(R.id.Businesswithtx, 13);
        sViewsWithIds.put(R.id.transactionacc, 14);
        sViewsWithIds.put(R.id.TransactionAmountst, 15);
        sViewsWithIds.put(R.id.TransactionAmount, 16);
        sViewsWithIds.put(R.id.businesstype, 17);
        sViewsWithIds.put(R.id.recommento, 18);
        sViewsWithIds.put(R.id.RecommendedTo, 19);
        sViewsWithIds.put(R.id.RecommendedTotx, 20);
        sViewsWithIds.put(R.id.RecommendedByli, 21);
        sViewsWithIds.put(R.id.RecommendedBy, 22);
        sViewsWithIds.put(R.id.RecommendedBytx, 23);
        sViewsWithIds.put(R.id.note, 24);
        sViewsWithIds.put(R.id.tvconfirm, 25);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemNotificationBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ItemNotificationBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[22]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[17]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[24]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.TextView) bindings[25]
            , (android.widget.LinearLayout) bindings[8]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.item == variableId) {
            setItem((com.justforentrepreneurs.j4eapp.abmainj4e.network.model.NotificationModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.justforentrepreneurs.j4eapp.abmainj4e.network.model.NotificationModel Item) {
        this.mItem = Item;
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}