import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;

// унаследуем методы из класса JFrame
public class DATABASE extends JFrame {

    // создаем arrayList
    public List<Book> data() {
        ArrayList<Book> arrayList = new ArrayList<>();

        // подключаем базу данных, делаем запрос на вывод книжек
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM BOOK");

// в arrayList записываем поля name и year из DataBase
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("NAME"));
                book.setYear(rs.getInt("YEAR"));
                arrayList.add(book);
            }
// создаем Jtable  и TableModel, которая записывается в JTable.
// Как параметр в TableModel передаем наш созданный arrayList
            TableModel model = new MyTableModel(arrayList);
            JTable table = new JTable(model);

// добавление на панель содержимого прокрутки таблицы
            getContentPane().add(new JScrollPane(table));
//устанавливает размер таблицы, Dimension хранит два числа ширину и высоту
            setPreferredSize(new Dimension(260, 220));
//метод pack(), подбирает оптимальным образом окно с учетом предпочтений всех элементов, размещенных в этом окне.
            pack();
// если установлен null, элементы не будут расставляться автоматически.
            setLocationRelativeTo(null);
// показывает сразу элемент, а не постепенно
            setVisible(true);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}