import scite.*;

public class Losange {
    Losange() {
        m_radius = 4;
        m_position = new Point2D();
    }

    Losange(int radius) {
        m_radius = radius;
        m_position = new Point2D();
    }

    Losange(int radius, int x, int y) {
        m_radius = radius;
        m_position = new Point2D(x, y);
    }

    int m_radius;
    Point2D m_position;

    double aire() {
        return m_radius * m_radius * 3.14;
    }

    double perimetre() {
        return m_radius * 2 * 3.14;
    }

    void dessinePlein() {
        for (int i = 0; i < m_radius * 2 + 1 + m_position.m_y; i++) {
            for (int j = 0; j < m_radius * 2 + 1 + m_position.m_x; j++) {
                if (j == 0) {
                    Ecran.afficher("|");
                } else if (i == m_radius * 2 + m_position.m_y - 1) {
                    Ecran.afficher("_");
                } else {
                    if (j < m_position.m_x) {
                        Ecran.afficher(" ");
                    } else {
                        if (i < m_radius) {
                            if (j <= m_radius + i && j >= m_radius - i) {
                                Ecran.afficher("*");
                            } else {
                                Ecran.afficher(" ");
                            }
                        } else {
                            if (j < m_radius * 3 - i && j > i - m_radius) {
                                Ecran.afficher("*");
                            } else {
                                Ecran.afficher(" ");
                            }
                        }
                    }
                }
            }
        }
    }
}
