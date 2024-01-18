package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HealthDataServlet")
public class HealthDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String fullName = request.getParameter("fullName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String socialSecurityNumber = request.getParameter("socialSecurityNumber");
        String healthInsuranceId = request.getParameter("healthInsuranceId");
        String emergencyContactName1 = request.getParameter("emergencyContactName1");
        String emergencyContactPhone1 = request.getParameter("emergencyContactPhone1");
        String emergencyContactName2 = request.getParameter("emergencyContactName2");
        String emergencyContactPhone2 = request.getParameter("emergencyContactPhone2");
        String allergies = request.getParameter("allergies");
        String previousIllnessesAndSurgeries = request.getParameter("previousIllnessesAndSurgeries");
        String familyMedicalHistory = request.getParameter("familyMedicalHistory");
        String currentMedications = request.getParameter("currentMedications");
        String medicationDosages = request.getParameter("medicationDosages");
        String medicationStartDates = request.getParameter("medicationStartDates");
        String medicationStopDates = request.getParameter("medicationStopDates");
        String immunizationHistory = request.getParameter("immunizationHistory");
        String bloodPressure = request.getParameter("bloodPressure");
        int heartRate = Integer.parseInt(request.getParameter("heartRate"));
        int respiratoryRate = Integer.parseInt(request.getParameter("respiratoryRate"));
        double temperature = Double.parseDouble(request.getParameter("temperature"));
        String bloodTests = request.getParameter("bloodTests");
        String urinalysis = request.getParameter("urinalysis");
        String imagingResults = request.getParameter("imagingResults");
        String medicalProcedures = request.getParameter("medicalProcedures");
        String chronicConditions = request.getParameter("chronicConditions");
        String primaryCarePhysician = request.getParameter("primaryCarePhysician");
        String specialistNames = request.getParameter("specialistNames");
        String smokingStatus = request.getParameter("smokingStatus");
        String alcoholConsumption = request.getParameter("alcoholConsumption");
        String exerciseRoutine = request.getParameter("exerciseRoutine");
        String hospitalizationDates = request.getParameter("hospitalizationDates");
        String hospitalizationReasons = request.getParameter("hospitalizationReasons");
        String alliedHealthProfessionalNotes = request.getParameter("alliedHealthProfessionalNotes");
        String insuranceProviderDetails = request.getParameter("insuranceProviderDetails");
        String policyNumbers = request.getParameter("policyNumbers");
        String advanceDirectives = request.getParameter("advanceDirectives");
        String patientNotes = request.getParameter("patientNotes");
        String appointmentHistory = request.getParameter("appointmentHistory");
        String billingAndPaymentInfo = request.getParameter("billingAndPaymentInfo");
        String consentAndAuthorizationForms = request.getParameter("consentAndAuthorizationForms");
        String patientPreferences = request.getParameter("patientPreferences");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
          
            connection = DBConnector.getConnection();

            
            String insertQuery = "INSERT INTO patient_details (user_id, full_name, date_of_birth, gender, address, phone_number, email, " +
                    "social_security_number, health_insurance_id, emergency_contact_name_1, emergency_contact_phone_1, " +
                    "emergency_contact_name_2, emergency_contact_phone_2, allergies, previous_illnesses_and_surgeries, " +
                    "family_medical_history, current_medications, medication_dosages, medication_start_dates, " +
                    "medication_stop_dates, immunization_history, blood_pressure, heart_rate, respiratory_rate, " +
                    "temperature, blood_tests, urinalysis, imaging_results, medical_procedures, chronic_conditions, " +
                    "primary_care_physician, specialist_names, smoking_status, alcohol_consumption, exercise_routine, " +
                    "hospitalization_dates, hospitalization_reasons, allied_health_professional_notes, " +
                    "insurance_provider_details, policy_numbers, advance_directives, patient_notes, appointment_history, " +
                    "billing_and_payment_info, consent_and_authorization_forms, patient_preferences) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("user_id");

            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, dateOfBirth);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, socialSecurityNumber);
            preparedStatement.setString(9, healthInsuranceId);
            preparedStatement.setString(10, emergencyContactName1);
            preparedStatement.setString(11, emergencyContactPhone1);
            preparedStatement.setString(12, emergencyContactName2);
            preparedStatement.setString(13, emergencyContactPhone2);
            preparedStatement.setString(14, allergies);
            preparedStatement.setString(15, previousIllnessesAndSurgeries);
            preparedStatement.setString(16, familyMedicalHistory);
            preparedStatement.setString(17, currentMedications);
            preparedStatement.setString(18, medicationDosages);
            preparedStatement.setString(19, medicationStartDates);
            preparedStatement.setString(20, medicationStopDates);
            preparedStatement.setString(21, immunizationHistory);
            preparedStatement.setString(22, bloodPressure);
            preparedStatement.setInt(23, heartRate);
            preparedStatement.setInt(24, respiratoryRate);
            preparedStatement.setDouble(25, temperature);
            preparedStatement.setString(26, bloodTests);
            preparedStatement.setString(27, urinalysis);
            preparedStatement.setString(28, imagingResults);
            preparedStatement.setString(29, medicalProcedures);
            preparedStatement.setString(30, chronicConditions);
            preparedStatement.setString(31, primaryCarePhysician);
            preparedStatement.setString(32, specialistNames);
            preparedStatement.setString(33, smokingStatus);
            preparedStatement.setString(34, alcoholConsumption);
            preparedStatement.setString(35, exerciseRoutine);
            preparedStatement.setString(36, hospitalizationDates);
            preparedStatement.setString(37, hospitalizationReasons);
            preparedStatement.setString(38, alliedHealthProfessionalNotes);
            preparedStatement.setString(39, insuranceProviderDetails);
            preparedStatement.setString(40, policyNumbers);
            preparedStatement.setString(41, advanceDirectives);
            preparedStatement.setString(42, patientNotes);
            preparedStatement.setString(43, appointmentHistory);
            preparedStatement.setString(44, billingAndPaymentInfo);
            preparedStatement.setString(45, consentAndAuthorizationForms);
            preparedStatement.setString(46, patientPreferences);

            preparedStatement.executeUpdate();

           
            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
      
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
