var settings = {
    "url": "https://zylalabs.com/api/1751/container+tracking+api/1367/create+request?blContainersRef=HLCUBU3220827900&shippingLine=HAPAG LLOYD",
    "method": "POST",
    "timeout": 0,
    "headers": {
        "Authorization": "5397|jNZWu3UVha8iGPAfLRY3lDt6ouy0PCSIYvQRtV2d"
    },
};

$.ajax(settings).done(function (response) {
    console.log(response);
});

var settings = {
    "url": "https://zylalabs.com/api/1751/container+tracking+api/1368/retrieve+response?requestId=2579122",
    "method": "GET",
    "timeout": 0,
    "headers": {
        "Authorization": "5397|jNZWu3UVha8iGPAfLRY3lDt6ouy0PCSIYvQRtV2d"
    },
};

$.ajax(settings).done(function (response) {
    console.log(response);
});

// [
//     {
//         "Message": "Success",
//         "Status": "Discharged",
//         "StatusId": 50,
//         "ReferenceNo": "",
//         "BLReferenceNo": "HLCUBU3220827900",
//         "ShippingLine": "HAPAG LLOYD",
//         "ContainerNumber": "TCNU1051902",
//         "ContainerTEU": "40",
//         "FromCountry": "CHINA",
//         "Pol": "SHANGHAI",
//         "LoadingDate": {
//             "Date": "2022-10-23",
//             "IsActual": true
//         },
//         "DepartureDate": {
//             "Date": "2022-10-23",
//             "IsActual": true
//         },
//         "TSPorts": [
//             {
//                 "Port": "BUSAN (PUSAN)",
//                 "ArrivalDate": {
//                     "Date": "2022-10-25",
//                     "IsActual": true
//                 },
//                 "DepartureDate": {
//                     "Date": "2022-10-31",
//                     "IsActual": true
//                 },
//                 "Vessel": "YM WELLBEING",
//                 "VesselIMO": "9820908",
//                 "VesselLatitude": "Not Supported",
//                 "VesselLongitude": "Not Supported"
//             },
//             {
//                 "Port": "JEBEL ALI",
//                 "ArrivalDate": {
//                     "Date": "2022-11-24",
//                     "IsActual": true
//                 },
//                 "DepartureDate": {
//                     "Date": "2022-12-04",
//                     "IsActual": true
//                 },
//                 "Vessel": "NORTHERN DEXTERITY",
//                 "VesselIMO": "9345996",
//                 "VesselLatitude": "Not Supported",
//                 "VesselLongitude": "Not Supported"
//             }
//         ],
//         "ToCountry": "KUWAIT",
//         "Pod": "SHUAIBA",
//         "ArrivalDate": {
//             "Date": "2022-12-06",
//             "IsActual": true
//         },
//         "DischargeDate": {
//             "Date": "2022-12-06",
//             "IsActual": true
//         },
//         "Vessel": "ATHOS",
//         "VesselIMO": "9406738",
//         "VesselLatitude": "Not Supported",
//         "VesselLongitude": "Not Supported",
//         "GateOutDate": "2023-01-03",
//         "EmptyReturnDate": "2023-01-03",
//         "FormatedTransitTime": "44 days",
//         "ETA": "-",
//         "FirstETA": "2022-12-06",
//         "BLContainerCount": 4,
//         "BLContainers": [
//             {
//                 "ContainerCode": "DFSU6483194",
//                 "ContainerTEU": "40",
//                 "LiveMapUrl": "https://shipsgo.com/live-map-container-tracking?query=DFSU6483194",
//                 "BLGateOutDate": "2023-01-03",
//                 "BLEmptyReturnDate": "2023-01-03"
//             },
//             {
//                 "ContainerCode": "FSCU8946539",
//                 "ContainerTEU": "40",
//                 "LiveMapUrl": "https://shipsgo.com/live-map-container-tracking?query=FSCU8946539",
//                 "BLGateOutDate": "2023-01-03",
//                 "BLEmptyReturnDate": "2023-01-03"
//             },
//             {
//                 "ContainerCode": "UACU5648077",
//                 "ContainerTEU": "40",
//                 "LiveMapUrl": "https://shipsgo.com/live-map-container-tracking?query=UACU5648077",
//                 "BLGateOutDate": "2023-01-03",
//                 "BLEmptyReturnDate": "2023-01-03"
//             }
//         ],
//         "LiveMapUrl": "https://shipsgo.com/live-map-container-tracking?query=TCNU1051902",
//         "Tags": []
//     }
// ]
