package de.moviemanager.ui.detail.modifiable;

import android.widget.ScrollView;

import androidx.annotation.IdRes;

import java.util.Date;
import java.util.Objects;
import java.util.function.Predicate;

import de.moviemanager.ui.detail.modifications.Modification;
import de.moviemanager.ui.view.DateSelectionView;
import de.moviemanager.util.ScrollViewUtils;

public class DateAttribute<X> extends ModifiableAttribute<X, Date> {
    private final int id;
    private final ScrollView root;
    private DateSelectionView editDate;
    private Predicate<X> enabled = m->true;
    private Predicate<X> error =m->false;

    public DateAttribute(ModifiableAppCompatActivity modContext, ScrollView root, @IdRes int id) {
        super(modContext);
        this.root = root;
        this.id = id;
    }

    @Override
    public void bindViews() {
        editDate = getContext().findViewById(id);
    }

    @Override
    public void bindListeners() {
        editDate.setDateChangeListener(oldDate -> getContext()
                .addModification(new Modification<>(oldDate, old -> {
                    ScrollViewUtils.scrollToViewIfNeeded(root, editDate);
                    editDate.setDate(old);
                }))
        );
    }

    @Override
    public void setContentModel(X model) {
        super.setContentModel(model);
        editDate.setEnabled(enabled.test(model));

        editDate.setError(error.test(model));


    }

    @Override
    protected void setContent(Date content) {
        editDate.setDate(content);
    }

    @Override
    public Date getContent() {
        return editDate.getDate();
    }

    public DateSelectionView accessDateSelectionView() {
        return this.editDate;
    }

    public void enableWhen(Predicate<X> enable){
       this.enabled=Objects.requireNonNull(enable);
    }

    public void errorWhen(Predicate<X> enable){
        this.error=Objects.requireNonNull(enable);
    }

}
