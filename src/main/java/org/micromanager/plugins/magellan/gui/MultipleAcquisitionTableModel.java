///////////////////////////////////////////////////////////////////////////////
// AUTHOR:       Henry Pinkard, henry.pinkard@gmail.com
//
// COPYRIGHT:    University of California, San Francisco, 2015
//
// LICENSE:      This file is distributed under the BSD license.
//               License text is included with the source distribution.
//
//               This file is distributed in the hope that it will be useful,
//               but WITHOUT ANY WARRANTY; without even the implied warranty
//               of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//
//               IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//               CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//               INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.
//

package main.java.org.micromanager.plugins.magellan.gui;

import main.java.org.micromanager.plugins.magellan.acq.AcquisitionsManager;
import main.java.org.micromanager.plugins.magellan.gui.GUI;
import javax.swing.table.AbstractTableModel;
import main.java.org.micromanager.plugins.magellan.acq.AcquisitionsManager;

/**
 *
 * @author Henry
 */
public class MultipleAcquisitionTableModel extends AbstractTableModel {

   private static final String[] COLUMNS = {"Name","Description","Status"};
   private AcquisitionsManager manager_;
   private GUI gui_;
   
   public MultipleAcquisitionTableModel(AcquisitionsManager manager, GUI gui) {
      super();
      manager_ = manager;
      gui_ = gui;
   }
   
   @Override
   public String getColumnName(int index) {
      return COLUMNS[index];
   }

   @Override
   public int getRowCount() {
      return manager_.getSize();
   }

   @Override
   public int getColumnCount() {
      return COLUMNS.length;
   }

   put this somewhere
   GUI.getInstance().acquisitionRunning(false);
   
   
   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      if (columnIndex == 0) {
         return manager_.getAcquisitionName(rowIndex);
      } else if (columnIndex == 1) {
         return manager_.getAcquisitionDescription(rowIndex);
      } else {
         return manager_.getAcqStatus(rowIndex);
      }
   }

   @Override
   public void setValueAt(Object value, int row, int col) {
       if (col == 0) {
         manager_.getAcquisitionSettings(row).name_ = (String) value;
      }
      gui_.storeCurrentAcqSettings();
   }
   
   @Override
   public boolean isCellEditable(int rowIndex, int colIndex) {
      return colIndex == 0 ? true : false;
   }


}
