import scite.*;

public class Rectangle {
    Rectangle() {
        m_height = 4;
        m_width = 8;
        m_position = new Point2D();
    }

    Rectangle(int height, int width) {
        m_height = height;
        m_width = width;
        m_position = new Point2D();
    }
    
    Rectangle(int height, int width, int x, int y) {
        m_height = height;
        m_width = width;
        m_position = new Point2D(x, y);
    }

    Rectangle(int height, int width, Point2D position) {
        m_height = height;
        m_width = width;
        m_position = position;
    }

    int m_height;
    int m_width;
    Point2D m_position;

    int aire() {
        return m_height * m_width;
    }

    int perimetre() {
        return m_height * 2 + m_width * 2;
    }

    void dessinePlein() {
        for (int i = 0; i < m_height + 1 + m_position.m_y; i++) {
            for (int j = 0; j < m_width + 1 + m_position.m_x; j++) {
                if (j == 0) {
                    Ecran.afficher("|");
                } else if (i == m_height + m_position.m_y) {
                    Ecran.afficher("_");
                } else if (j < m_position.m_x + 1) {
                    Ecran.afficher(" ");
                } else if (i > m_height - 1) {
                    Ecran.afficher(" ");
                }
                else {
                    Ecran.afficher("*");
                }
            }
            Ecran.afficherln();
        }
    }

    void dessineVide() {
        for (int i = 0; i < m_height; i++) {
            for (int j = 0; j < m_width; j++) {
                if (j == 0 || j == m_width - 1 || i == 0 || i == m_height - 1) {
                    Ecran.afficher("*");
                }
                else {
                    Ecran.afficher(".");
                }
            }
            Ecran.afficherln();
        }
    }
}
