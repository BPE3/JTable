import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// унаследуем методы от TableModel
public class MyTableModel implements TableModel {

    // Создаем интерфейс TableModelListener ??? Правильно?
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    // переопределяем arraylist
    private List<Book> arrayList;

    public MyTableModel(List<Book> arrayList) {
        this.arrayList = arrayList;
    }

    // добавляем слушателей модели.
    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    //Методом getColumnClass определяем тип сущностей book
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    // getColumnCount - устанавливаем количество столбцов
    public int getColumnCount() {
        return 2;
    }

    // устанавливаем название столбцов
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Name";
            case 1:
                return "Year";
        }
        return "";
    }

    // getRowCount возвращает количество строк, которое будет отображаться в таблице.
    // указываем, что их количество ссответствует arrayList
    public int getRowCount() {
        return arrayList.size();
    }

    // getValueAt устанавливает какие значения находяться в какой таблице
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book bean = arrayList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bean.getName();
            case 1:
                return bean.getYear();
        }
        return "";
    }

    // При наследовании класса TableModel мы должны определить isCellEditable, removeTableModelListener, setValueAt
    //Returns true if the cell at rowIndex and columnIndex is editable.
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //  Removes a listener from the list that is notified each time a change to the data model occurs.
    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    // Sets the value in the cell at columnIndex and rowIndex to aValue.
    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }
}
