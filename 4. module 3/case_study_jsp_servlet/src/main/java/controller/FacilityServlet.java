package controller;

import bean.*;
import service.FacilityService;
import service.Impl.FacilityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = {"/facilities"})
public class FacilityServlet extends HttpServlet {
    private FacilityService facilityService = new FacilityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateFacility(request,response);
                break;
            case "search":
                searchFacility(request,response);
                break;
            default:
                break;


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "create":
                showCreateFacilityForm(request, response);
                break;
            case "edit":
                showEditFacilityForm(request,response);
                break;
            case "delete":
                deleteFacility(request,response);
                break;
            default:
                facilityList(request, response);
                break;

        }
    }

    public void facilityList(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = this.facilityService.findAll();
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("pages/facility/facility-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateFacilityForm(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypeList = this.facilityService.getServiceType();
        List<RentingType> rentingTypeList = this.facilityService.getRentingType();

        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentingTypeList", rentingTypeList);

        try {
            request.getRequestDispatcher("pages/facility/create-facility.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("input-id");
        String name = request.getParameter("input-name");
        double usableArea = Double.parseDouble(request.getParameter("input-usable-area"));
        int floors = Integer.parseInt(request.getParameter("input-floors"));
        int customerMax = Integer.parseInt(request.getParameter("input-customer-max"));
        double cost = Double.parseDouble(request.getParameter("input-cost"));

        int rentingTypeID = Integer.parseInt(request.getParameter("input-rentingType"));
        int serviceTypeID = Integer.parseInt(request.getParameter("input-serviceType"));


        Facility facility = new Facility();
        ServiceType serviceType = new ServiceType();
        RentingType rentingType = new RentingType();

        facility.setId(id);
        facility.setName(name);
        facility.setUsableArea(usableArea);
        facility.setFloors(floors);
        facility.setCustomerMax(customerMax);
        facility.setCost(cost);
        serviceType.setId(serviceTypeID);
        rentingType.setId(rentingTypeID);

        facility.setServiceType(serviceType);
        facility.setRentingType(rentingType);

        this.facilityService.save(facility);
        try {
            response.sendRedirect("/facilities");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEditFacilityForm(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Facility facility =  this.facilityService.findById(id);

        List<ServiceType> serviceTypeList = this.facilityService.getServiceType();
        List<RentingType> rentingTypeList = this.facilityService.getRentingType();

        request.setAttribute("serviceTypeList",serviceTypeList);
        request.setAttribute("rentingTypeList",rentingTypeList);
        request.setAttribute("facility",facility);
        try {
            request.getRequestDispatcher("/pages/facility/edit-facility.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateFacility(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("input-id");
        String name = request.getParameter("input-name");
        double usableArea = Double.parseDouble(request.getParameter("input-usable-area"));
        int floors = Integer.parseInt(request.getParameter("input-floors"));
        int customerMax = Integer.parseInt(request.getParameter("input-customer-max"));
        double cost = Double.parseDouble(request.getParameter("input-cost"));

        int rentingTypeID = Integer.parseInt(request.getParameter("input-rentingType"));
        int serviceTypeID = Integer.parseInt(request.getParameter("input-serviceType"));

        Facility facility = new Facility();
        ServiceType serviceType = new ServiceType();
        RentingType rentingType = new RentingType();

        facility.setId(id);
        facility.setName(name);
        facility.setUsableArea(usableArea);
        facility.setFloors(floors);
        facility.setCustomerMax(customerMax);
        facility.setCost(cost);
        serviceType.setId(serviceTypeID);
        rentingType.setId(rentingTypeID);

        facility.setServiceType(serviceType);
        facility.setRentingType(rentingType);

        this.facilityService.update(facility);
        try {
            response.sendRedirect("/facilities");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFacility(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        this.facilityService.remove(id);
        try {
            response.sendRedirect("/facilities");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchFacility(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("searchName");
        List<Facility> facilityList = this.facilityService.findByName(name);
        request.setAttribute("facilityList",facilityList);
        try {
            request.getRequestDispatcher("/pages/facility/facility-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
