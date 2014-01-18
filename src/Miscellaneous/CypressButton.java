package Miscellaneous;

import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.buttons.Button;
/**
 *
 * @author Zach Kimberg, Anthony
 */
public class CypressButton extends Button {
    
    DriverStationEnhancedIO m_cypress;
    int m_buttonNumber;
    
    public CypressButton(DriverStationEnhancedIO cypress, int buttonNumber) {
        m_cypress = cypress;
        m_buttonNumber = buttonNumber;
    }
    
    public boolean get() {
        try {
            return m_cypress.getButton(m_buttonNumber);
        } catch(EnhancedIOException e) {
            return false;
        }
    }
}

// 