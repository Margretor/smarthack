using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tasks.Models
{
    public class Log
    {
        [Key]
        public int Id { get; set; }

        public int Task { get; set; }
        public string User { get; set; }
        public DateTime Date { get; set; }
        public TimeSpan Time { get; set; }

    }
}