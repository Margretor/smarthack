using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tasks.DTO
{
    public class LogDTO
    {
        public DateTime Date { get; set; }
        public string User { get; set; }
        public TimeSpan Time { get; set; }
    }
}