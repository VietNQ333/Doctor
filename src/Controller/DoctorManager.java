package Controller;

import model.Doctor;
import View.View;
import java.util.ArrayList;

public class DoctorManager {
    private View view;
    private ArrayList<Doctor> doctorList;

    public DoctorManager() {
        view = new View();
        doctorList = new ArrayList<>();
    }

    public void run() {
        while (true) {
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    updateDoctor();
                    break;
                case 3:
                    deleteDoctor();
                    break;
                case 4:
                    searchDoctor();
                    break;
                case 5:
                    return;
            }
        }
    }

  private void addDoctor() {
    String code = view.getInputString("Enter code: ");
    // Kiểm tra xem mã đã tồn tại chưa
    if (isCodeExists(code)) {
        view.showMessage("Code already exists.");
        return;
    }
    String name = view.getInputString("Enter name: ");
    String specialization = view.getInputString("Enter specialization: ");
    int availability = view.getInputInt("Enter availability: ");
    // Kiểm tra trùng lặp ở đây
    doctorList.add(new Doctor(code, name, specialization, availability));
    view.showMessage("Doctor added successfully.");
}


  private void updateDoctor() {
    String code = view.getInputString("Enter code: ");
    Doctor doctorToUpdate = getDoctorByCode(code);
    if (doctorToUpdate == null) {
        view.showMessage("Doctor not found.");
        return;
    }
    // Cập nhật thông tin của bác sĩ
    String newName = view.getInputString("Enter new name: ");
    String newSpecialization = view.getInputString("Enter new specialization: ");
    int newAvailability = view.getInputInt("Enter new availability: ");
    doctorToUpdate.setName(newName);
    doctorToUpdate.setSpecialization(newSpecialization);
    doctorToUpdate.setAvailability(newAvailability);
    view.showMessage("Doctor updated successfully.");
}


 private void deleteDoctor() {
    String code = view.getInputString("Enter code: ");
    Doctor doctorToDelete = getDoctorByCode(code);
    if (doctorToDelete == null) {
        view.showMessage("Doctor not found.");
        return;
    }
    doctorList.remove(doctorToDelete);
    view.showMessage("Doctor deleted successfully.");
}


private void searchDoctor() {
    String nameToSearch = view.getInputString("Enter name to search: ");
    ArrayList<Doctor> foundDoctors = new ArrayList<>();
    for (Doctor doctor : doctorList) {
        if (doctor.getName().equalsIgnoreCase(nameToSearch)) {
            foundDoctors.add(doctor);
        }
    }
    if (foundDoctors.isEmpty()) {
        view.showMessage("No doctor found with that name.");
    } else {
        view.showMessage("Found doctors:");
        for (Doctor doctor : foundDoctors) {
            view.showMessage(doctor.toString());
        }
    }
}
private boolean isCodeExists(String code) {
    for (Doctor doctor : doctorList) {
        if (doctor.getCode().equalsIgnoreCase(code)) {
            return true;
        }
    }
    return false;
}
private Doctor getDoctorByCode(String code) {
    for (Doctor doctor : doctorList) {
        if (doctor.getCode().equalsIgnoreCase(code)) {
            return doctor;
        }
    }
    return null;
}

}
